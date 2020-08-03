package no.nav.klage.varsel

import org.springframework.stereotype.Service

@Service
class VarselSender(
    private val varselConnection: VarselConnection,
    private val varselXmlGenerator: VarselXmlGenerator
) {
    fun send(varsel: Varsel) {
        varselConnection.sendVarsel(varsel.callId, varselXmlGenerator.generateXML(varsel))
    }
}
