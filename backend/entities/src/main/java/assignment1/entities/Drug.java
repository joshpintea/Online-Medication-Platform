package assignment1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drug extends BaseEntity {
    private String name;
    private Long dosage;

    @ManyToMany
    @JoinTable(
            name = "drug_to_side_effects",
            joinColumns = {@JoinColumn(name = "drug_id")},
            inverseJoinColumns = {@JoinColumn(name = "side_effect_id")}
    )
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

    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", dosage=" + dosage +
                ", sideEffects=" + sideEffects +
                '}';
    }
}
