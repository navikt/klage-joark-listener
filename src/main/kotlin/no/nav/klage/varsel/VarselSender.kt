package no.nav.klage.varsel

import no.nav.klage.util.getLogger
import no.nav.melding.virksomhet.varsel.v1.varsel.Varsel
import org.springframework.stereotype.Service

@Service
class VarselSender(
    private val varselConnection: VarselConnection,
    private val varselXmlGenerator: VarselXmlGenerator
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    fun send(callId: String, varsel: Varsel) {
        val xml = varselXmlGenerator.generateXML(varsel)
        logger.debug("Sending varsel $xml")
        varselConnection.sendVarsel(callId, xml)
    }
}
