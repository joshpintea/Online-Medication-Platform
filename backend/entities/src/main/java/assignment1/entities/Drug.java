package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drug extends BaseEntity {
    private String name;
    private Long dosage;

    @ManyToMany(mappedBy = "drugs")
    private List<SideEffect> sideEffects = new ArrayList<>();

    @ManyToMany(mappedBy = "drugs")
    private List<MedicationPlan> medicationPlans = new ArrayList<>();

    public Drug() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDosage() {
        return dosage;
    }

    public void setDosage(Long dosage) {
        this.dosage = dosage;
    }

    public List<SideEffect> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(List<SideEffect> sideEffects) {
        this.sideEffects = sideEffects;
    }

    public List<MedicationPlan> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlan> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }
}
