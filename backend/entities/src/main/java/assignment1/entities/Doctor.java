package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "doctor")
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    private List<MedicationPlan> medicationPlans = new ArrayList<>();

    public Doctor() {
        this.role = UserRole.ROLE_DOCTOR;
    }

    public Doctor(Long id, String username, String gender, String address, String name, Date birthDate) {
        super(id, username, gender, address, name, birthDate);
        this.role = UserRole.ROLE_DOCTOR;
    }

    public Doctor(Long id, String username, String gender, String address, String name, Date birthDate, List<MedicationPlan> medicationPlans) {
        super(id, username, gender, address, name, birthDate);
        this.medicationPlans = medicationPlans;
        this.role = UserRole.ROLE_DOCTOR;
    }

    public List<MedicationPlan> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(List<MedicationPlan> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }
}
