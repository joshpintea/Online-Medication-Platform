
package core.recommendation_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="patientId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "patientId"
})
@XmlRootElement(name = "ActivityRecommendationRequest")
public class ActivityRecommendationRequest {

    protected long patientId;

    /**
     * Gets the value of the patientId property.
     * 
     */
    public long getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     */
    public void setPatientId(long value) {
        this.patientId = value;
    }

}
