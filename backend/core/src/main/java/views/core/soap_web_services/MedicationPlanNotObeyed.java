
package views.core.soap_web_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MedicationPlanNotObeyed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MedicationPlanNotObeyed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="medication_plan" type="{soap_web_services.core.views}MedicationPlanModel" minOccurs="0"/>
 *         &lt;element name="intake_intervals" type="{soap_web_services.core.views}MedicationPlanIntervalModelArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedicationPlanNotObeyed", propOrder = {
    "medicationPlan",
    "intakeIntervals"
})
public class MedicationPlanNotObeyed {

    @XmlElementRef(name = "medication_plan", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<MedicationPlanModel> medicationPlan;
    @XmlElementRef(name = "intake_intervals", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<MedicationPlanIntervalModelArray> intakeIntervals;

    /**
     * Gets the value of the medicationPlan property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MedicationPlanModel }{@code >}
     *     
     */
    public JAXBElement<MedicationPlanModel> getMedicationPlan() {
        return medicationPlan;
    }

    /**
     * Sets the value of the medicationPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MedicationPlanModel }{@code >}
     *     
     */
    public void setMedicationPlan(JAXBElement<MedicationPlanModel> value) {
        this.medicationPlan = value;
    }

    /**
     * Gets the value of the intakeIntervals property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MedicationPlanIntervalModelArray }{@code >}
     *     
     */
    public JAXBElement<MedicationPlanIntervalModelArray> getIntakeIntervals() {
        return intakeIntervals;
    }

    /**
     * Sets the value of the intakeIntervals property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MedicationPlanIntervalModelArray }{@code >}
     *     
     */
    public void setIntakeIntervals(JAXBElement<MedicationPlanIntervalModelArray> value) {
        this.intakeIntervals = value;
    }

}
