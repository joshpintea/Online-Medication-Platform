
package core.recommendation_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for activity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="activity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="activityLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isViolated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isNormal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activity", propOrder = {
    "id",
    "startDate",
    "endDate",
    "activityLabel",
    "isViolated",
    "isNormal"
})
public class Activity {

    protected long id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(required = true)
    protected String activityLabel;
    protected boolean isViolated;
    protected boolean isNormal;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the activityLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityLabel() {
        return activityLabel;
    }

    /**
     * Sets the value of the activityLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityLabel(String value) {
        this.activityLabel = value;
    }

    /**
     * Gets the value of the isViolated property.
     * 
     */
    public boolean isIsViolated() {
        return isViolated;
    }

    /**
     * Sets the value of the isViolated property.
     * 
     */
    public void setIsViolated(boolean value) {
        this.isViolated = value;
    }

    /**
     * Gets the value of the isNormal property.
     * 
     */
    public boolean isIsNormal() {
        return isNormal;
    }

    /**
     * Sets the value of the isNormal property.
     * 
     */
    public void setIsNormal(boolean value) {
        this.isNormal = value;
    }

}
