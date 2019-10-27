package assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "doctor")
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    private Set<MedicationPlan> medicationPlans = new HashSet<>();

    public Doctor() {
        this.role = UserRole.ROLE_DOCTOR;
    }

    public Doctor(Long id, String username, String gender, String address, String name, Date birthDate) {
        super(id, username, gender, address, name, birthDate);
        this.role = UserRole.ROLE_DOCTOR;
    }

    public Doctor(Long id, String username, String gender, String address, String name, Date birthDate, Set<MedicationPlan> medicationPlans) {
        super(id, username, gender, address, name, birthDate);
        this.medicationPlans = medicationPlans;
        this.role = UserRole.ROLE_DOCTOR;
    }

    public Set<MedicationPlan> getMedicationPlans() {
        return medicationPlans;
    }

    public void setMedicationPlans(Set<MedicationPlan> medicationPlans) {
        this.medicationPlans = medicationPlans;
    }
}
