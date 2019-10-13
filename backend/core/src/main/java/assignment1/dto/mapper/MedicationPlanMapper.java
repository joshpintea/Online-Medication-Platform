package assignment1.dto.mapper;

import assignment1.dto.MedicationPlanDto;
import assignment1.entities.MedicationPlan;

import java.util.stream.Collectors;

public class MedicationPlanMapper {

    public static MedicationPlan convertToEntity(MedicationPlanDto medicationPlanDto) {
        MedicationPlan medicationPlan = new MedicationPlan();
        medicationPlan.setId(medicationPlanDto.getId());
        medicationPlan.setDrugs(medicationPlanDto.getDrugsList()
                                .stream()
                                .map(DrugMapper::convertToEntity)
                                .collect(Collectors.toList()));
        medicationPlan.setEndDate(medicationPlanDto.getEndDate());
        medicationPlan.setStartDate(medicationPlanDto.getStartDate());
        medicationPlan.setIntakeInterval(medicationPlanDto.getIntakeInterval());
        medicationPlan.setDoctor(DoctorMapper.convertToEntity(medicationPlanDto.getDoctorDto()));
        medicationPlan.setPatient(PatientMapper.convertToEntity(medicationPlanDto.getPatientDto()));

        return medicationPlan;
    }

    public static MedicationPlanDto convertToDto(MedicationPlan medicationPlan) {
        MedicationPlanDto medicationPlanDto = new MedicationPlanDto();
        medicationPlanDto.setId(medicationPlan.getId());
        medicationPlanDto.setStartDate(medicationPlan.getStartDate());
        medicationPlanDto.setEndDate(medicationPlan.getEndDate());
        medicationPlanDto.setIntakeInterval(medicationPlan.getIntakeInterval());
        medicationPlanDto.setDoctorDto(DoctorMapper.convertToDto(medicationPlan.getDoctor()));
        medicationPlanDto.setPatientDto(PatientMapper.convertToDto(medicationPlan.getPatient()));
        medicationPlanDto.setDrugsList(
                medicationPlan.getDrugs().stream()
                .map(DrugMapper::convertToDto)
                .collect(Collectors.toList())
        );

        return medicationPlanDto;
    }
}
