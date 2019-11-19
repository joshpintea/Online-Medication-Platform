package assignment1.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity(name="medication_plan_taken")
public class MedicationPlanTaken extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medication_plan_id")
    private MedicationPlan medicationPlan;

    @Column(name="day")
    private Date date;


    @Column(name="hour")
    private Integer hour;


    public MedicationPlanTaken() {
    }

    public MedicationPlanTaken(MedicationPlan medicationPlan, Date date, Integer hour) {
        this.medicationPlan = medicationPlan;
        this.date = date;
        this.hour = hour;
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

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }
}
