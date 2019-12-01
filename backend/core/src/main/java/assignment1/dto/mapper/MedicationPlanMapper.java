package assignment1.dto.mapper;

import assignment1.dto.MedPlanIntervalSoapDto;
import assignment1.dto.MedPlanNotObeyed;
import assignment1.dto.MedPlanSoapDto;
import assignment1.dto.MedicationPlanDto;
import assignment1.entities.MedicationPlan;
import assignment1.util.DateUtil;
import views.core.soap_web_services.MedicationPlanIntervalModel;
import views.core.soap_web_services.MedicationPlanModel;
import views.core.soap_web_services.MedicationPlanNotObeyed;

import java.util.stream.Collectors;

public class MedicationPlanMapper {

    public static MedicationPlan convertToEntity(MedicationPlanDto medicationPlanDto) {
        MedicationPlan medicationPlan = new MedicationPlan();
        medicationPlan.setId(medicationPlanDto.getId());
        medicationPlan.setDrugs(medicationPlanDto.getDrugsList()
                .stream()
                .map(DrugMapper::convertToEntity)
                .collect(Collectors.toSet()));
        medicationPlan.setEndDate(medicationPlanDto.getEndDate());
        medicationPlan.setStartDate(medicationPlanDto.getStartDate());
        medicationPlan.setIntakeIntervalPeriod(medicationPlanDto.getIntakeInterval());
        medicationPlan.setDoctor(DoctorMapper.convertToEntity(medicationPlanDto.getDoctorDto()));
        medicationPlan.setPatient(PatientMapper.convertToEntity(medicationPlanDto.getPatientDto()));

        return medicationPlan;
    }

    public static MedicationPlanDto convertToDto(MedicationPlan medicationPlan) {
        MedicationPlanDto medicationPlanDto = new MedicationPlanDto();
        medicationPlanDto.setId(medicationPlan.getId());
        medicationPlanDto.setStartDate(medicationPlan.getStartDate());
        medicationPlanDto.setEndDate(medicationPlan.getEndDate());
        medicationPlanDto.setIntakeInterval(medicationPlan.getIntakeIntervalPeriod());
        medicationPlanDto.setDoctorDto(DoctorMapper.convertToDto(medicationPlan.getDoctor()));
        medicationPlanDto.setPatientDto(PatientMapper.convertToDto(medicationPlan.getPatient()));
        medicationPlanDto.setDrugsList(
                medicationPlan.getDrugs().stream()
                        .map(DrugMapper::convertToDto)
                        .collect(Collectors.toList())
        );

        return medicationPlanDto;
    }

    public static MedPlanSoapDto convertToDto(MedicationPlanModel medicationPlanModel) {
        return new MedPlanSoapDto(
                medicationPlanModel.getId(),
                DateUtil.convertXmlGregorianCalendarToDate(medicationPlanModel.getStartDate().getValue()),
                DateUtil.convertXmlGregorianCalendarToDate(medicationPlanModel.getEndDate().getValue()),
                medicationPlanModel.getIntakeIntervalPeriod().getValue().longValue(),
                medicationPlanModel.getDoctorId().getValue(),
                medicationPlanModel.getPatientId().getValue()
                );
    }

    public static MedPlanIntervalSoapDto convertToDto(MedicationPlanIntervalModel medPlanInterval) {
        return new MedPlanIntervalSoapDto(
                medPlanInterval.getId(),
                DateUtil.convertXmlGregorianCalendarToDate(medPlanInterval.getDay().getValue()),
                medPlanInterval.getHour().getValue().longValue(),
                medPlanInterval.getIntakeIntervalEnd().getValue().longValue(),
                medPlanInterval.getIntakeIntervalStart().getValue().longValue(),
                medPlanInterval.getTakenOnTime().getValue(),
                medPlanInterval.getMedicationPlanId().getValue()
        );
    }

    public static MedPlanNotObeyed convertToDto(MedicationPlanNotObeyed medicationPlanNotObeyed) {
        return new MedPlanNotObeyed(
                convertToDto(medicationPlanNotObeyed.getMedicationPlan().getValue()),
                medicationPlanNotObeyed.getIntakeIntervals()
                        .getValue()
                        .getMedicationPlanIntervalModel()
                        .stream().map(MedicationPlanMapper::convertToDto).collect(Collectors.toList())
        );
    }
}
