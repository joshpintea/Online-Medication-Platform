
package core.soap_web_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import views.core.soap_web_services.MedicationPlanNotObeyedArray;


/**
 * <p>Java class for get_not_obeyed_medication_planResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_not_obeyed_medication_planResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_not_obeyed_medication_planResult" type="{soap_web_services.core.views}MedicationPlanNotObeyedArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_not_obeyed_medication_planResponse", propOrder = {
    "getNotObeyedMedicationPlanResult"
})
public class GetNotObeyedMedicationPlanResponse {

    @XmlElementRef(name = "get_not_obeyed_medication_planResult", namespace = "soap_web_services.core", type = JAXBElement.class, required = false)
    protected JAXBElement<MedicationPlanNotObeyedArray> getNotObeyedMedicationPlanResult;

    /**
     * Gets the value of the getNotObeyedMedicationPlanResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MedicationPlanNotObeyedArray }{@code >}
     *     
     */
    public JAXBElement<MedicationPlanNotObeyedArray> getGetNotObeyedMedicationPlanResult() {
        return getNotObeyedMedicationPlanResult;
    }

    /**
     * Sets the value of the getNotObeyedMedicationPlanResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MedicationPlanNotObeyedArray }{@code >}
     *     
     */
    public void setGetNotObeyedMedicationPlanResult(JAXBElement<MedicationPlanNotObeyedArray> value) {
        this.getNotObeyedMedicationPlanResult = value;
    }

}
