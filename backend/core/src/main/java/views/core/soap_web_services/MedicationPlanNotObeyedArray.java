
package views.core.soap_web_services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MedicationPlanNotObeyedArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MedicationPlanNotObeyedArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MedicationPlanNotObeyed" type="{soap_web_services.core.views}MedicationPlanNotObeyed" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedicationPlanNotObeyedArray", propOrder = {
    "medicationPlanNotObeyed"
})
public class MedicationPlanNotObeyedArray {

    @XmlElement(name = "MedicationPlanNotObeyed", nillable = true)
    protected List<MedicationPlanNotObeyed> medicationPlanNotObeyed;

    /**
     * Gets the value of the medicationPlanNotObeyed property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the medicationPlanNotObeyed property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedicationPlanNotObeyed().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MedicationPlanNotObeyed }
     * 
     * 
     */
    public List<MedicationPlanNotObeyed> getMedicationPlanNotObeyed() {
        if (medicationPlanNotObeyed == null) {
            medicationPlanNotObeyed = new ArrayList<MedicationPlanNotObeyed>();
        }
        return this.medicationPlanNotObeyed;
    }

}
