package assignment1.service.pildispenser;

import assignment1.dto.MedicationPlanDto;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.entities.MedicationPlan;
import assignment1.entities.MedicationPlanTaken;
import assignment1.repository.MedicationPlanRepository;
import assignment1.repository.MedicationPlanTakenRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PillDispenserImpl implements PillDispenser {

    private MedicationPlanTakenRepository medicationPlanTakenRepository;
    private MedicationPlanRepository medicationPlanRepository;

    public PillDispenserImpl(MedicationPlanTakenRepository medicationPlanTakenRepository,
                             MedicationPlanRepository medicationPlanRepository) {
        this.medicationPlanTakenRepository = medicationPlanTakenRepository;
        this.medicationPlanRepository = medicationPlanRepository;
    }

    @Override
    public List<MedicationPlanDto> getNotTakenMedicationPlans(Long idPatient) {
        Date today = new Date(new java.util.Date().getTime());

        List<MedicationPlan> medicationPlans = this.medicationPlanRepository.getAllByPatientIdAndStartDateGreaterThanAndEndDateLessThan(idPatient, today, today);

        List<MedicationPlan> medicationPlanNotTaken = new ArrayList<>();
        for (MedicationPlan medicationPlan : medicationPlans) {
            List<MedicationPlanTaken> medicationPlanTakens = this.medicationPlanTakenRepository.getAllByMedicationPlan_IdAndDate(medicationPlan.getId(), today);

            // patient did not take his medication for current date
            if (medicationPlanTakens.size() == 0) {
                medicationPlanNotTaken.add(medicationPlan);
            }
        }

        return medicationPlanNotTaken.stream().map(MedicationPlanMapper::convertToDto).collect(Collectors.toList());
    }
}
