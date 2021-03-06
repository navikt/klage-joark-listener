//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.08.13 at 06:43:56 PM CEST
//


package no.nav.melding.virksomhet.varsel.v1.varsel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.javacodegeeks.examples.xjc package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Varsel_QNAME = new QName("http://nav.no/melding/virksomhet/varsel/v1/varsel", "Varsel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.javacodegeeks.examples.xjc
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Varsel }
     *
     */
    public Varsel createVarsel() {
        return new Varsel();
    }

    /**
     * Create an instance of {@link PersonIdent }
     *
     */
    public PersonIdent createPersonIdent() {
        return new PersonIdent();
    }

    /**
     * Create an instance of {@link Kodeverdi }
     *
     */
    public Kodeverdi createKodeverdi() {
        return new Kodeverdi();
    }

    /**
     * Create an instance of {@link AktoerId }
     *
     */
    public AktoerId createAktoerId() {
        return new AktoerId();
    }

    /**
     * Create an instance of {@link Parameter }
     *
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link Varslingstyper }
     *
     */
    public Varslingstyper createVarslingstyper() {
        return new Varslingstyper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Varsel }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://nav.no/melding/virksomhet/varsel/v1/varsel", name = "Varsel")
    public JAXBElement<Varsel> createVarsel(Varsel value) {
        return new JAXBElement<Varsel>(_Varsel_QNAME, Varsel.class, null, value);
    }

}
