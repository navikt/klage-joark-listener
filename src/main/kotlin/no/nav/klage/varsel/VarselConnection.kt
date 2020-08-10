package no.nav.klage.varsel

import no.nav.klage.util.getLogger
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component

@Component
class VarselConnection(private val varselJmsTemplate: JmsTemplate) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    fun sendVarsel(callId: String, xml: String) {
        logger.debug("Sending message $callId on ${varselJmsTemplate.defaultDestinationName}")
        try {
            varselJmsTemplate.send {
                val msg = it.createTextMessage(xml)
                msg.setStringProperty("callId", callId)
                msg
            }
            // TODO Metric?
        } catch(ex: Exception) {
            logger.error("Failed to send message $callId to ${varselJmsTemplate.defaultDestinationName}", ex)
            // TODO Metric?
        }
    }
}
