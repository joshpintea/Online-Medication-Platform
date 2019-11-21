package assignment1.service.pildispenser;

import assignment1.dto.IntakeInterval;
import assignment1.dto.MedicationPlanDto;
import assignment1.dto.MedicationPlanInterval;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.entities.MedicationPlan;
import assignment1.entities.MedicationPlanTaken;
import assignment1.entities.Patient;
import assignment1.exception.InvalidInterval;
import assignment1.exception.PatientNotFound;
import assignment1.repository.MedicationPlanRepository;
import assignment1.repository.MedicationPlanTakenRepository;
import assignment1.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PillDispenserServiceImpl implements PillDispenserService {

    private MedicationPlanTakenRepository medicationPlanTakenRepository;
    private MedicationPlanRepository medicationPlanRepository;
    private PatientRepository patientRepository;
    private Logger logger = LoggerFactory.getLogger(PillDispenserServiceImpl.class);

    public PillDispenserServiceImpl(MedicationPlanTakenRepository medicationPlanTakenRepository,
                                    MedicationPlanRepository medicationPlanRepository,
                                    PatientRepository patientRepository) {
        this.medicationPlanTakenRepository = medicationPlanTakenRepository;
        this.medicationPlanRepository = medicationPlanRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<MedicationPlanInterval> getNotTakenMedicationPlans(Long idPatient) throws PatientNotFound {
        /**
         * Return a list of medications plan for the given patient
         * with his intake intervals generated after the intakeIntervalPeriod for the current day.
         */
        Date today = new Date(new java.util.Date().getTime());
        Optional<Patient> patient = this.patientRepository.findById(idPatient);
        patient.orElseThrow(() -> new PatientNotFound(idPatient));

        List<MedicationPlan> allMedicationsPlan = this.medicationPlanRepository.getAllByPatientId(idPatient);
        List<MedicationPlan> medicationPlans = new ArrayList<>();
        for (MedicationPlan medicationPlan : allMedicationsPlan) {
            if (medicationPlan.getStartDate().before(today) && medicationPlan.getEndDate().after(today)) {
                medicationPlans.add(medicationPlan);
            }
        }

        List<MedicationPlanInterval> medicationsPlanNotTaken = new ArrayList<>();

        for (MedicationPlan medicationPlan : medicationPlans) {
            List<MedicationPlanTaken> medicationPlanTakens = this.medicationPlanTakenRepository.getAllByMedicationPlan_IdAndDate(medicationPlan.getId(), today);
            List<IntakeInterval> intakeIntervals = this.computeIntakeIntervals(medicationPlan.getIntakeIntervalPeriod());

            MedicationPlanDto medicationPlanDto = MedicationPlanMapper.convertToDto(medicationPlan);
            List<IntakeInterval> takenIntervals = new ArrayList<>();

            for (MedicationPlanTaken medicationPlanTaken : medicationPlanTakens) {
                takenIntervals.add(new IntakeInterval(medicationPlanTaken.getIntakeIntervalStart(),
                        medicationPlanTaken.getIntakeIntervalEnd()));
            }

            List<IntakeInterval> toBeTaken = new ArrayList<>();

            // diff between all intake intervals and already taken intervals for the current day
            for (IntakeInterval interval : intakeIntervals) {
                boolean notTaken = true;
                for (IntakeInterval taken : takenIntervals) {
                    if (interval.getStartHour() == taken.getStartHour() && interval.getEndHour() == taken.getEndHour()) {
                        notTaken = false;
                    }
                }

                if (notTaken) {
                    toBeTaken.add(interval);
                }
            }

            if (toBeTaken.size() > 0) {
                medicationsPlanNotTaken.add(new MedicationPlanInterval(medicationPlanDto, toBeTaken));
            }

        }

        return medicationsPlanNotTaken;
    }

    @Override
    public MedicationPlanDto takeMedication(MedicationPlanDto medicationPlanDto, IntakeInterval intakeInterval) throws InvalidInterval {
        java.util.Date currentDate = new java.util.Date();

        Integer hour = currentDate.getHours();


        if (hour < intakeInterval.getStartHour() || hour > intakeInterval.getEndHour()) {
            throw new InvalidInterval();
        }

        MedicationPlan medicationPlan = this.medicationPlanRepository.getOne(medicationPlanDto.getId());

        MedicationPlanTaken medicationPlanTaken = new MedicationPlanTaken(
                medicationPlan,
                new Date(currentDate.getTime()),
                hour,
                intakeInterval.getStartHour(),
                intakeInterval.getEndHour()
        );


        this.medicationPlanTakenRepository.save(medicationPlanTaken);
        return medicationPlanDto;
    }


    @Override
    public void patientDidNotTakeMedication(MedicationPlanDto medicationPlanDto) {
        this.logger.info(medicationPlanDto.getPatientDto().getUsername() + " did not take his medication at the prescribed time.");
    }

    private List<IntakeInterval> computeIntakeIntervals(Integer intakeIntervalPeriod) {
        java.util.Date currentDate = new java.util.Date();
        int hour = currentDate.getHours();

        List<IntakeInterval> intakeIntervals = new ArrayList<>();
        for (int i = 0; i < 24 / intakeIntervalPeriod + 1; i++) {
            if (i % 2 == 0) {
                int start = i * intakeIntervalPeriod;
                int end = (i + 1) * intakeIntervalPeriod - 1;
                if (start >= 24 || hour > end) {
                    continue;
                }

                if (end >= 24) {
                    end = 23;
                }

                intakeIntervals.add(new IntakeInterval(start, end));
            }
        }

        return intakeIntervals;
    }
}
