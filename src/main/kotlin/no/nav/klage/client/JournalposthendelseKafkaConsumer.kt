package no.nav.klage.client

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
    fun listen(consumerRecord: ConsumerRecord<String, String>) {
        logger.debug("Journalposthendelse received from Kafka topic: {}", consumerRecord)
        // TODO Fetch journalpost from SAF
//        safClient.getJournalpost(journalpostId)
        // TODO Send varsel
    }

}
