package no.nav.klage.client

import no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord
import no.nav.klage.getLogger
import no.nav.klage.varsel.VarselSender
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class JournalposthendelseKafkaConsumer(
    private val varselSender: VarselSender
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @KafkaListener(topics = ["\${KAFKA_TOPIC}"])
    fun listen(consumerRecord: ConsumerRecord<String, JournalfoeringHendelseRecord>) {
        logger.debug("Journalposthendelse received from Kafka topic: {}", consumerRecord)
        logger.debug("Value of event. " +
                "\nmottaksKanal: {}" +
                "\nbehandlingstema: {}" +
                "\njournalpostId: {}" +
                "\njournalpostStatus: {}" +
                "\nhendelsesId: {}" +
                "\nhendelsesType: {}" +
                "\ntemaGammelt: {}" +
                "\ntemaNytt: {}" +
                "\nversjon: {}" +
                "\nkanalReferanseId: {}",
            consumerRecord.value().mottaksKanal,
            consumerRecord.value().behandlingstema,
            consumerRecord.value().journalpostId,
            consumerRecord.value().journalpostStatus,
            consumerRecord.value().hendelsesId,
            consumerRecord.value().hendelsesType,
            consumerRecord.value().temaGammelt,
            consumerRecord.value().temaNytt,
            consumerRecord.value().versjon,
            consumerRecord.value().kanalReferanseId
        )
        // TODO Send varsel
    }

}
