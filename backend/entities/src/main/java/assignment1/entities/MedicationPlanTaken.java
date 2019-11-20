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

    @Column(name="intake_interval_start")
    private Integer intakeIntervalStart;

    @Column(name="intake_interval_end")
    private Integer intakeIntervalEnd;

    public MedicationPlanTaken() {
    }

    public MedicationPlanTaken(MedicationPlan medicationPlan, Date date, Integer hour, Integer intakeIntervalStart, Integer intakeIntervalEnd) {
        this.medicationPlan = medicationPlan;
        this.date = date;
        this.hour = hour;
        this.intakeIntervalEnd = intakeIntervalEnd;
        this.intakeIntervalStart = intakeIntervalStart;
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

    public Integer getIntakeIntervalStart() {
        return intakeIntervalStart;
    }

    public void setIntakeIntervalStart(Integer intakeIntervalStart) {
        this.intakeIntervalStart = intakeIntervalStart;
    }

    public Integer getIntakeIntervalEnd() {
        return intakeIntervalEnd;
    }

    public void setIntakeIntervalEnd(Integer intakeIntervalEnd) {
        this.intakeIntervalEnd = intakeIntervalEnd;
    }
}
