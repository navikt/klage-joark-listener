package no.nav.klage.client

import no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord
import no.nav.klage.util.getLogger
import no.nav.klage.varsel.VarselSender
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class JournalposthendelseKafkaConsumer(
    private val varselSender: VarselSender,
    private val safClient: SafClient
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @KafkaListener(topics = ["\${KAFKA_TOPIC}"])
    fun listen(journalpostRecord: ConsumerRecord<String, JournalfoeringHendelseRecord>) {
        logger.debug("Journalposthendelse received from Kafka topic: {}", journalpostRecord)

        logger.debug("Fetching journalpost from SAF")
        val journalpostResponse = safClient.getJournalpost(journalpostRecord.value().journalpostId.toString())
        logger.debug("Journalpost fetched from SAF: {}", journalpostResponse)

//        if (journalpostRecord.value().isToBeConsidered()) {
//            logger.debug("Fetching journalpost from SAF")
//            val journalpostResponse = safClient.getJournalpost(journalpostRecord.value().journalpostId.toString())
//            logger.debug("Journalpost fetched from SAF: {}", journalpostResponse)
//        } else {
//            logger.debug("Journalposthendelse was not considered")
//        }

        // TODO Send varsel
    }
}

private fun JournalfoeringHendelseRecord.isToBeConsidered() = temaGammelt == "FOR" || temaNytt == "FOR"