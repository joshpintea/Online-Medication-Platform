package assignment1.service.pildispenser;

import assignment1.dto.MedicationPlanDto;

import java.util.List;

public interface PillDispenser {
    List<MedicationPlanDto> getNotTakenMedicationPlans(Long idPatient);
}
