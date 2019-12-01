package assignment1.dto;

import java.sql.Date;

public class MedPlanSoapDto {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Long intakeIntervalPeriod;
    private Long doctorId;
    private Long patientId;

    public MedPlanSoapDto() {

    }

    public MedPlanSoapDto(Long id, Date startDate, Date endDate, Long intakeIntervalPeriod, Long doctorId, Long patientId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.intakeIntervalPeriod = intakeIntervalPeriod;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getIntakeIntervalPeriod() {
        return intakeIntervalPeriod;
    }

    public void setIntakeIntervalPeriod(Long intakeIntervalPeriod) {
        this.intakeIntervalPeriod = intakeIntervalPeriod;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
