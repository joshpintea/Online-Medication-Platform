
package core.soap_web_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for say_helloResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="say_helloResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="say_helloResult" type="{soap_web_services.core}stringArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "say_helloResponse", propOrder = {
    "sayHelloResult"
})
public class SayHelloResponse {

    @XmlElementRef(name = "say_helloResult", namespace = "soap_web_services.core", type = JAXBElement.class, required = false)
    protected JAXBElement<StringArray> sayHelloResult;

    /**
     * Gets the value of the sayHelloResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public JAXBElement<StringArray> getSayHelloResult() {
        return sayHelloResult;
    }

    /**
     * Sets the value of the sayHelloResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public void setSayHelloResult(JAXBElement<StringArray> value) {
        this.sayHelloResult = value;
    }

}
