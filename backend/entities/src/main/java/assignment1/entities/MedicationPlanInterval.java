package assignment1.entities;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="medication_plan_interval")
public class MedicationPlanInterval extends BaseEntity {

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

    @Column(name="taken_on_time")
    @ColumnDefault("0")
    private Boolean takenOnTime;

    public MedicationPlanInterval() {
    }

    public MedicationPlanInterval(MedicationPlan medicationPlan, Date date, Integer hour, Integer intakeIntervalStart, Integer intakeIntervalEnd) {
        this.medicationPlan = medicationPlan;
        this.date = date;
        this.hour = hour;
        this.intakeIntervalEnd = intakeIntervalEnd;
        this.intakeIntervalStart = intakeIntervalStart;
    }

    public MedicationPlanInterval(MedicationPlan medicationPlan, Date date, Integer hour, Integer intakeIntervalStart, Integer intakeIntervalEnd, Boolean takenOnTime) {
        this.medicationPlan = medicationPlan;
        this.date = date;
        this.hour = hour;
        this.intakeIntervalStart = intakeIntervalStart;
        this.intakeIntervalEnd = intakeIntervalEnd;
        this.takenOnTime = takenOnTime;
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

    public Boolean getTakenOnTime() {
        return takenOnTime;
    }

    public void setTakenOnTime(Boolean takenOnTime) {
        this.takenOnTime = takenOnTime;
    }
}
