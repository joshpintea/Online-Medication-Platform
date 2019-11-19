package assignment1.service.pildispenser;

import assignment1.dto.MedicationPlanDto;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.entities.MedicationPlan;
import assignment1.entities.MedicationPlanTaken;
import assignment1.exception.InvalidInterval;
import assignment1.repository.MedicationPlanRepository;
import assignment1.repository.MedicationPlanTakenRepository;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PillDispenserImpl implements PillDispenser {

    private MedicationPlanTakenRepository medicationPlanTakenRepository;
    private MedicationPlanRepository medicationPlanRepository;

    private Logger logger = LoggerFactory.getLogger(PillDispenserImpl.class);

    public PillDispenserImpl(MedicationPlanTakenRepository medicationPlanTakenRepository,
                             MedicationPlanRepository medicationPlanRepository) {
        this.medicationPlanTakenRepository = medicationPlanTakenRepository;
        this.medicationPlanRepository = medicationPlanRepository;
    }

    @Override
    public List<MedicationPlanDto> getNotTakenMedicationPlans(Long idPatient) {
        Date today = new Date(new java.util.Date().getTime());

        List<MedicationPlan> allMedicationsPlan = this.medicationPlanRepository.findAll();
        List<MedicationPlan> medicationPlans = new ArrayList<>();
        for (MedicationPlan medicationPlan : allMedicationsPlan) {
            if (medicationPlan.getStartDate().before(today) && medicationPlan.getEndDate().after(today)) {
                medicationPlans.add(medicationPlan);
            }
        }

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

    @Override
    public MedicationPlanDto takeMedication(MedicationPlanDto medicationPlanDto, Pair<Integer, Integer> medicationPlanInterval) throws InvalidInterval {
        java.util.Date currentDate = new java.util.Date();

        Integer hour = currentDate.getHours();
        MedicationPlan medicationPlan = this.medicationPlanRepository.getOne(medicationPlanDto.getId());

        Integer intakeInterval = medicationPlan.getIntakeInterval();
//        List<Pair<Integer, Integer>> intervals = computeIntakeIntervals(intakeInterval);

        if (hour < medicationPlanInterval.getKey() || hour > medicationPlanInterval.getValue()) {
            throw new InvalidInterval();
        }

//        boolean validIntakeInterval = false;
//
//        for (Pair<Integer, Integer> interval: intervals) {
//            if (hour >= interval.getKey() && hour <= interval.getValue()) {
//                validIntakeInterval = true;
//                break;
//            }
//        }
//
//        if (!validIntakeInterval) {
//            throw new InvalidInterval();
//        }


        MedicationPlanTaken medicationPlanTaken = new MedicationPlanTaken(
                medicationPlan,
                new Date(currentDate.getTime()),
                hour
        );


        this.medicationPlanTakenRepository.save(medicationPlanTaken);
        return medicationPlanDto;
    }

    @Override
    public void patientDidNotTakeMedication(MedicationPlanDto medicationPlanDto) {
        this.logger.info(medicationPlanDto.getPatientDto().getUsername() + " did not take his medication at the prescribed time.");
    }

    private List<Pair<Integer, Integer>> computeIntakeIntervals(Integer intakeInterval) {
        java.util.Date currentDate = new java.util.Date();
        int hour = currentDate.getHours();

        List<Pair<Integer, Integer>> intakeIntervals = new ArrayList<>();
        for (int i = 0; i < 24 / intakeInterval + 1; i++) {
            if (i % 2 == 0) {
                int start = i * intakeInterval;
                int end = (i+1) * intakeInterval - 1;
                if (start >=24 || hour > end) {
                    break;
                }

                if (end >= 24) {
                    end = 23;
                }

                intakeIntervals.add(new Pair<>(start, end));
            }
        }

        return intakeIntervals;
    }
}
