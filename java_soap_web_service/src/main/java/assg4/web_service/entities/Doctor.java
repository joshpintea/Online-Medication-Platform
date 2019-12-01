package assg4.web_service.entities;

import javax.persistence.Entity;
import java.sql.Date;

@Entity(name = "doctor")
public class Doctor extends User {

    public Doctor() {
        this.role = UserRole.ROLE_DOCTOR;
    }

    public Doctor(Long id, String username, String gender, String address, String name, Date birthDate) {
        super(id, username, gender, address, name, birthDate);
        this.role = UserRole.ROLE_DOCTOR;
    }

//    public Doctor(Long id, String username, String gender, String address, String name, Date birthDate) {
//        super(id, username, gender, address, name, birthDate);
//        this.role = UserRole.ROLE_DOCTOR;
//    }

//    public Set<MedicationPlan> getMedicationPlans() {
//        return medicationPlans;
//    }
//
//    public void setMedicationPlans(Set<MedicationPlan> medicationPlans) {
//        this.medicationPlans = medicationPlans;
//    }
}
