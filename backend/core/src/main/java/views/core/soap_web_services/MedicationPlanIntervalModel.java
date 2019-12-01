
package views.core.soap_web_services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Java class for MedicationPlanIntervalModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MedicationPlanIntervalModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="day" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="hour" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="intake_interval_end" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="intake_interval_start" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="taken_on_time" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="medication_plan_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedicationPlanIntervalModel", propOrder = {
    "id",
    "day",
    "hour",
    "intakeIntervalEnd",
    "intakeIntervalStart",
    "takenOnTime",
    "medicationPlanId"
})
public class MedicationPlanIntervalModel {

    protected Long id;
    @XmlElementRef(name = "day", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> day;
    @XmlElementRef(name = "hour", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> hour;
    @XmlElementRef(name = "intake_interval_end", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> intakeIntervalEnd;
    @XmlElementRef(name = "intake_interval_start", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> intakeIntervalStart;
    @XmlElementRef(name = "taken_on_time", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> takenOnTime;
    @XmlElementRef(name = "medication_plan_id", namespace = "soap_web_services.core.views", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> medicationPlanId;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the day property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDay(JAXBElement<XMLGregorianCalendar> value) {
        this.day = value;
    }

    /**
     * Gets the value of the hour property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setHour(JAXBElement<BigInteger> value) {
        this.hour = value;
    }

    /**
     * Gets the value of the intakeIntervalEnd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIntakeIntervalEnd() {
        return intakeIntervalEnd;
    }

    /**
     * Sets the value of the intakeIntervalEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIntakeIntervalEnd(JAXBElement<BigInteger> value) {
        this.intakeIntervalEnd = value;
    }

    /**
     * Gets the value of the intakeIntervalStart property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getIntakeIntervalStart() {
        return intakeIntervalStart;
    }

    /**
     * Sets the value of the intakeIntervalStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setIntakeIntervalStart(JAXBElement<BigInteger> value) {
        this.intakeIntervalStart = value;
    }

    /**
     * Gets the value of the takenOnTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getTakenOnTime() {
        return takenOnTime;
    }

    /**
     * Sets the value of the takenOnTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setTakenOnTime(JAXBElement<Boolean> value) {
        this.takenOnTime = value;
    }

    /**
     * Gets the value of the medicationPlanId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getMedicationPlanId() {
        return medicationPlanId;
    }

    /**
     * Sets the value of the medicationPlanId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setMedicationPlanId(JAXBElement<Long> value) {
        this.medicationPlanId = value;
    }

}
