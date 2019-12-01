
package views.core.soap_web_services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MedicationPlanIntervalModelArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MedicationPlanIntervalModelArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MedicationPlanIntervalModel" type="{soap_web_services.core.views}MedicationPlanIntervalModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedicationPlanIntervalModelArray", propOrder = {
    "medicationPlanIntervalModel"
})
public class MedicationPlanIntervalModelArray {

    @XmlElement(name = "MedicationPlanIntervalModel", nillable = true)
    protected List<MedicationPlanIntervalModel> medicationPlanIntervalModel;

    /**
     * Gets the value of the medicationPlanIntervalModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the medicationPlanIntervalModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedicationPlanIntervalModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MedicationPlanIntervalModel }
     * 
     * 
     */
    public List<MedicationPlanIntervalModel> getMedicationPlanIntervalModel() {
        if (medicationPlanIntervalModel == null) {
            medicationPlanIntervalModel = new ArrayList<MedicationPlanIntervalModel>();
        }
        return this.medicationPlanIntervalModel;
    }

}
