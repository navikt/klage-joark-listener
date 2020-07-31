package no.nav.klage.client

import no.nav.klage.getLogger
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class JournalposthendelseKafkaConsumer {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @KafkaListener(topics = ["\${KAFKA_TOPIC}"])
    fun listen(consumerRecord: ConsumerRecord<String, String>) {
        logger.debug("Journalposthendelse received from Kafka topic: {}", consumerRecord)
    }

}