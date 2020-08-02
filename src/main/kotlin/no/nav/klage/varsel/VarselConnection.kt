package no.nav.klage.varsel

import no.nav.klage.getLogger
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class VarselConnection(private val varselJmsTemplate: JmsTemplate) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    fun sendVarsel(xml: String) {
        val callId = UUID.randomUUID() // TODO Proper call ID?
        logger.debug("Sending message on ${varselJmsTemplate.defaultDestinationName}")
        try {
            varselJmsTemplate.send {
                val msg = it.createTextMessage(xml)
                msg.setStringProperty("callId", callId.toString())
                msg
            }
            // TODO Metric?
        } catch(ex: Exception) {
            logger.error("Failed to send message to ${varselJmsTemplate.defaultDestinationName}", ex)
            // TODO Metric?
        }
    }
}
