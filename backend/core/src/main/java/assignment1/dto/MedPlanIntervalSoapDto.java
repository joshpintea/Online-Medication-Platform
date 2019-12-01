package assignment1.dto;

import java.sql.Date;

public class MedPlanIntervalSoapDto {
    private Long id;
    private Date date;
    private Long hour;
    private Long intakeIntervalEnd;
    private Long intakeIntervalStart;
    private Boolean takenOnTime;
    private Long medicationPlanId;

    public MedPlanIntervalSoapDto(Long id, Date date, Long hour, Long intakeIntervalEnd, Long intakeIntervalStart, Boolean takenOnTime, Long medicationPlanId) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.intakeIntervalEnd = intakeIntervalEnd;
        this.intakeIntervalStart = intakeIntervalStart;
        this.takenOnTime = takenOnTime;
        this.medicationPlanId = medicationPlanId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getHour() {
        return hour;
    }

    public void setHour(Long hour) {
        this.hour = hour;
    }

    public Long getIntakeIntervalEnd() {
        return intakeIntervalEnd;
    }

    public void setIntakeIntervalEnd(Long intakeIntervalEnd) {
        this.intakeIntervalEnd = intakeIntervalEnd;
    }

    public Long getIntakeIntervalStart() {
        return intakeIntervalStart;
    }

    public void setIntakeIntervalStart(Long intakeIntervalStart) {
        this.intakeIntervalStart = intakeIntervalStart;
    }

    public Boolean getTakenOnTime() {
        return takenOnTime;
    }

    public void setTakenOnTime(Boolean takenOnTime) {
        this.takenOnTime = takenOnTime;
    }

    public Long getMedicationPlanId() {
        return medicationPlanId;
    }

    public void setMedicationPlanId(Long medicationPlanId) {
        this.medicationPlanId = medicationPlanId;
    }
}
