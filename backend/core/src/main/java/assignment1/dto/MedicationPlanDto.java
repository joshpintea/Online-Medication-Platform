package assignment1.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class MedicationPlanDto implements Serializable {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Integer intakeInterval;
    private DoctorDto doctorDto;
    private List<DrugDto> drugsList;
    private PatientDto patientDto;

    public MedicationPlanDto() {
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

    public Integer getIntakeInterval() {
        return intakeInterval;
    }

    public void setIntakeInterval(Integer intakeInterval) {
        this.intakeInterval = intakeInterval;
    }

    public DoctorDto getDoctorDto() {
        return doctorDto;
    }

    public void setDoctorDto(DoctorDto doctorDto) {
        this.doctorDto = doctorDto;
    }

    public List<DrugDto> getDrugsList() {
        return drugsList;
    }

    public void setDrugsList(List<DrugDto> drugsList) {
        this.drugsList = drugsList;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }
}
