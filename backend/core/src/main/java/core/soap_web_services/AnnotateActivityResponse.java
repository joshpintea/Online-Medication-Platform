
package core.soap_web_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import views.core.soap_web_services.ActivityModel;


/**
 * <p>Java class for annotate_activityResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="annotate_activityResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annotate_activityResult" type="{soap_web_services.core.views}ActivityModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annotate_activityResponse", propOrder = {
    "annotateActivityResult"
})
public class AnnotateActivityResponse {

    @XmlElementRef(name = "annotate_activityResult", namespace = "soap_web_services.core", type = JAXBElement.class, required = false)
    protected JAXBElement<ActivityModel> annotateActivityResult;

    /**
     * Gets the value of the annotateActivityResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ActivityModel }{@code >}
     *     
     */
    public JAXBElement<ActivityModel> getAnnotateActivityResult() {
        return annotateActivityResult;
    }

    /**
     * Sets the value of the annotateActivityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ActivityModel }{@code >}
     *     
     */
    public void setAnnotateActivityResult(JAXBElement<ActivityModel> value) {
        this.annotateActivityResult = value;
    }

}
