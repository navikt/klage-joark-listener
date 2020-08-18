package no.nav.klage.client

import no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord
import no.nav.klage.domain.saf.Journalpost
import no.nav.klage.util.getLogger
import no.nav.klage.varsel.VarselSender
import no.nav.klage.varsel.varselFromJournalfoeringHendelse
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

private const val behandlingstemaKlageUnderenhet = "ab0019"
private const val timeoutMs = 1000 * 60 * 60 * 24

@Component
class JournalposthendelseKafkaConsumer(
    private val varselSender: VarselSender,
    private val safClient: SafClient
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @Value("\${NAIS_CLUSTER_NAME}")
    private lateinit var cluster: String

    private val cache = mutableMapOf<String, Long>()

    @KafkaListener(topics = ["\${KAFKA_TOPIC}"])
    fun listen(journalpostRecord: ConsumerRecord<String, JournalfoeringHendelseRecord>) {
        logger.debug("Journalposthendelse received from Kafka topic: {}", journalpostRecord)

        val record = journalpostRecord.value()
        if (record.hasBehandlingstemaKlage()) {
            val journalpostResponse = safClient.getJournalpost(record.journalpostId.toString())

            journalpostResponse.data?.journalpost?.run {
                val klageId = getKlageId()
                logger.debug("Sjekk varsel {}, {}, {}, {}", klageId, record.isMidlertidigJournalfoert(), canSendVarsel(klageId), cluster)
                if (record.isMidlertidigJournalfoert() && canSendVarsel(klageId)) {
                    runCatching {
                        varselSender.send(
                            record.hendelsesId.toString(), varselFromJournalfoeringHendelse(
                                aktoerId = bruker?.id ?: throw Exception("Aktoerid not present in record"),
                                fornavn = avsenderMottakerNavn ?: throw Exception("User name not present in record"),
                                journalfoeringsdato = datoOpprettet ?: throw Exception("Date not present in record")
                            )
                        )
                    }.onFailure {
                        logger.error("Sending varsel for ${record.hendelsesId} failed.", it)
                    }.onSuccess {
                        logger.debug("Varsel sent for ${record.hendelsesId}")
                        klageId?.let { addKlageIdToCache(it) }
                        cleanCache()
                    }
                }
            }
        }
    }

    private fun Journalpost.getKlageId(): String? =
        this.tilleggsopplysninger.find { it.nokkel == "klage_id" }?.nokkel

    private fun canSendVarsel(klageId: String?): Boolean {
        return klageId != null && !cache.containsKey(klageId) && cluster == "dev-fss" // TODO Only send varsel in dev until verified
    }

    private fun JournalfoeringHendelseRecord.isMidlertidigJournalfoert() =
        this.journalpostStatus.toString() == "M"

    private fun JournalfoeringHendelseRecord.hasBehandlingstemaKlage() =
        this.behandlingstema.toString() == behandlingstemaKlageUnderenhet

    private fun addKlageIdToCache(klageId: String) {
        cache[klageId] = System.currentTimeMillis() + timeoutMs
    }

    private fun cleanCache() {
        cache.entries.removeIf { it.value < System.currentTimeMillis() }
    }

}
