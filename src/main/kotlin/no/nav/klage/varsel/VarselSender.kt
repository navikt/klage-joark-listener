package no.nav.klage.varsel

import no.nav.melding.virksomhet.varsel.v1.varsel.Varsel
import org.springframework.stereotype.Service
import java.util.*

@Service
class VarselSender(
    private val varselConnection: VarselConnection,
    private val varselXmlGenerator: VarselXmlGenerator
) {
    fun send(callId: String, varsel: Varsel) {
        varselConnection.sendVarsel(callId, varselXmlGenerator.generateXML(varsel))
    }
}
