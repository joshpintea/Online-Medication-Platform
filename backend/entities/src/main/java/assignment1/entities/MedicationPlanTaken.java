package assignment1.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity(name="medication_plan_taken")
public class MedicationPlanTaken extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "medication_plan_id")
    private MedicationPlan medicationPlan;

    @Column(name="day")
    private Date date;

    public MedicationPlanTaken() {
    }

    public MedicationPlan getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
