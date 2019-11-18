package assignment1.service.pildispenser;

import assignment1.dto.MedicationPlanDto;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.repository.MedicationPlanRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PillDispenserImpl implements PillDispenser {

    private MedicationPlanRepository medicationPlanRepository;

    public PillDispenserImpl(MedicationPlanRepository medicationPlanRepository) {
        this.medicationPlanRepository = medicationPlanRepository;
    }

    @Override
    public List<MedicationPlanDto> getActiveMedicationsPlanForPatient(Long idPatient) {
        Date today = new Date(new java.util.Date().getTime());

        return this.medicationPlanRepository.getAllByPatientIdAndStartDateGreaterThanAndEndDateLessThan(idPatient, today)
                .stream()
                .map(MedicationPlanMapper::convertToDto)
                .collect(Collectors.toList());
    }
}
