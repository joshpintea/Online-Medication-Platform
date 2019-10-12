package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "patient")
public class Patient extends User {

    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private Caregiver caregiver;

    @OneToMany(mappedBy = "patient")
    private List<MedicationPlan> medicationPlans;

    public Patient() {
        this.role = UserRole.PATIENT;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public List<MedicationPlan> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlan> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }
}
