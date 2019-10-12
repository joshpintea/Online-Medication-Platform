package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "doctor")
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    private List<MedicationPlan> medicationPlans;

    public Doctor() {
        this.role = UserRole.DOCTOR;
    }

    public List<MedicationPlan> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlan> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }
}
