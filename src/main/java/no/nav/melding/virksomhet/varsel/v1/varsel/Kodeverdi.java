//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.08.13 at 06:43:56 PM CEST
//


package no.nav.melding.virksomhet.varsel.v1.varsel;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Kodeverdi complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Kodeverdi">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="kodeRef" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kodeverdi", propOrder = {
    "value"
})
@XmlSeeAlso({
    Varslingstyper.class
})
public class Kodeverdi {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "kodeRef")
    @XmlSchemaType(name = "anyURI")
    protected String kodeRef;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the kodeRef property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKodeRef() {
        return kodeRef;
    }

    /**
     * Sets the value of the kodeRef property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKodeRef(String value) {
        this.kodeRef = value;
    }

}
