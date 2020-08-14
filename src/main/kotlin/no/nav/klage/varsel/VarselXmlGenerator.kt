package no.nav.klage.varsel

import no.nav.melding.virksomhet.varsel.v1.varsel.ObjectFactory
import no.nav.melding.virksomhet.varsel.v1.varsel.Varsel
import org.springframework.stereotype.Service
import java.io.StringWriter
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT

@Service
class VarselXmlGenerator {
    private val varselFactory = ObjectFactory()
    private lateinit var marshaller: Marshaller

    init {
        val jaxbContext = JAXBContext.newInstance(Varsel::class.java)
        marshaller = jaxbContext.createMarshaller()
        marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true)
    }

    fun generateXML(varsel: Varsel): String {
        val sw = StringWriter()
        val jaxbElement = varselFactory.createVarsel(varsel)
        marshaller.marshal(jaxbElement, sw)
        return sw.toString()
    }

}
