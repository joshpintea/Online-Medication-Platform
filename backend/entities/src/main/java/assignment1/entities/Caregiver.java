package assignment1.entities;

import javax.persistence.Entity;
import java.sql.Date;

@Entity(name = "caregiver")
public class Caregiver extends User {

    public Caregiver() {
        super();
        this.role = UserRole.ROLE_CAREGIVER;
    }

    public Caregiver(Long id, String username, String gender, String address, String name, Date birthDate) {
        super(id, username, gender, address, name, birthDate);
        this.role = UserRole.ROLE_CAREGIVER;
    }

}
