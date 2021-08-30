package no.nav.klage.client

import no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord
import no.nav.klage.domain.saf.Journalpost
import no.nav.klage.util.getLogger
import no.nav.slackposter.SlackClient
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component



@Component
class JournalposthendelseKafkaConsumer(
    private val safClient: SafClient,
    private val slackClient: SlackClient
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
        private const val BEHANDLINGSTEMA_ANKE_TEST = "ab0454"
        private const val behandlingstemaKlageUnderenhet = "ab0019"
        private const val timeoutMs = 1000 * 60 * 60 * 24
    }

    @Value("\${NAIS_CLUSTER_NAME}")
    private lateinit var cluster: String

    private val cache = mutableMapOf<String, Long>()

    @KafkaListener(topics = ["\${KAFKA_TOPIC}"])
    fun listen(journalpostRecord: ConsumerRecord<String, JournalfoeringHendelseRecord>) {
        logger.debug("Journalposthendelse received from Kafka topic: {}", journalpostRecord)

        val record = journalpostRecord.value()
        if (record.isAnkeRecord()) {
            slackClient.postMessage("Fikk inn en anke! ($record)")

        }
//        if (record.hasBehandlingstemaKlage()) {
//
//            val journalpostResponse = safClient.getJournalpost(record.journalpostId.toString())
//
//            journalpostResponse.data?.journalpost?.run {
//                val klageId = getKlageId()
//                //Send noe til en slack-kanal
//            }
//        }
    }

    private fun Journalpost.getKlageId(): String? =
        this.tilleggsopplysninger.find { it.nokkel == "klage_id" }?.nokkel

    private fun JournalfoeringHendelseRecord.isMidlertidigJournalfoert() =
        this.journalpostStatus.toString() == "M"

    private fun JournalfoeringHendelseRecord.hasBehandlingstemaKlage() =
        this.behandlingstema.toString() == behandlingstemaKlageUnderenhet

    private fun JournalfoeringHendelseRecord.isAnkeRecord() =
        this.behandlingstema.toString() == BEHANDLINGSTEMA_ANKE_TEST

    private fun addKlageIdToCache(klageId: String) {
        cache[klageId] = System.currentTimeMillis() + timeoutMs
    }

    private fun cleanCache() {
        cache.entries.removeIf { it.value < System.currentTimeMillis() }
    }

}
