//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.08.13 at 06:43:56 PM CEST
//


package no.nav.melding.virksomhet.varsel.v1.varsel;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Varslingstyper complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Varslingstyper">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://nav.no/melding/virksomhet/varsel/v1/varsel>Kodeverdi">
 *       &lt;attribute name="kodeverksRef" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Varslingstyper")
public class Varslingstyper
    extends Kodeverdi
{

    @XmlAttribute(name = "kodeverksRef")
    @XmlSchemaType(name = "anyURI")
    protected String kodeverksRef;

    /**
     * Gets the value of the kodeverksRef property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKodeverksRef() {
        return kodeverksRef;
    }

    /**
     * Sets the value of the kodeverksRef property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKodeverksRef(String value) {
        this.kodeverksRef = value;
    }

}
