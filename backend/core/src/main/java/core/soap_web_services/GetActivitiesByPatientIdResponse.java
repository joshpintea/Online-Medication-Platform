
package core.soap_web_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import views.core.soap_web_services.ActivityModelArray;


/**
 * <p>Java class for get_activities_by_patient_idResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_activities_by_patient_idResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_activities_by_patient_idResult" type="{soap_web_services.core.views}ActivityModelArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_activities_by_patient_idResponse", propOrder = {
    "getActivitiesByPatientIdResult"
})
public class GetActivitiesByPatientIdResponse {

    @XmlElementRef(name = "get_activities_by_patient_idResult", namespace = "soap_web_services.core", type = JAXBElement.class, required = false)
    protected JAXBElement<ActivityModelArray> getActivitiesByPatientIdResult;

    /**
     * Gets the value of the getActivitiesByPatientIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ActivityModelArray }{@code >}
     *     
     */
    public JAXBElement<ActivityModelArray> getGetActivitiesByPatientIdResult() {
        return getActivitiesByPatientIdResult;
    }

    /**
     * Sets the value of the getActivitiesByPatientIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ActivityModelArray }{@code >}
     *     
     */
    public void setGetActivitiesByPatientIdResult(JAXBElement<ActivityModelArray> value) {
        this.getActivitiesByPatientIdResult = value;
    }

}
