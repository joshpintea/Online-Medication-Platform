package assignment1.service.pildispenser;

import assignment1.dto.IntakeInterval;
import assignment1.dto.MedicationPlanDto;
import assignment1.dto.mapper.MedicationPlanMapper;
import assignment1.entities.MedicationPlan;
import assignment1.entities.MedicationPlanInterval;
import assignment1.entities.Patient;
import assignment1.exception.InvalidInterval;
import assignment1.exception.PatientNotFound;
import assignment1.repository.MedicationPlanRepository;
import assignment1.repository.MedicationPlanIntervalRepository;
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

    private MedicationPlanIntervalRepository medicationPlanIntervalRepository;
    private MedicationPlanRepository medicationPlanRepository;
    private PatientRepository patientRepository;
    private Logger logger = LoggerFactory.getLogger(PillDispenserServiceImpl.class);

    public PillDispenserServiceImpl(MedicationPlanIntervalRepository medicationPlanIntervalRepository,
                                    MedicationPlanRepository medicationPlanRepository,
                                    PatientRepository patientRepository) {
        this.medicationPlanIntervalRepository = medicationPlanIntervalRepository;
        this.medicationPlanRepository = medicationPlanRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<assignment1.dto.MedicationPlanInterval> getNotTakenMedicationPlans(Long idPatient) throws PatientNotFound {
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

        List<assignment1.dto.MedicationPlanInterval> medicationsPlanNotTaken = new ArrayList<>();

        for (MedicationPlan medicationPlan : medicationPlans) {
            List<MedicationPlanInterval> medicationPlanIntervals = this.medicationPlanIntervalRepository.getAllByMedicationPlan_IdAndDate(medicationPlan.getId(), today);
            List<IntakeInterval> intakeIntervals = this.computeIntakeIntervals(medicationPlan.getIntakeIntervalPeriod());

            MedicationPlanDto medicationPlanDto = MedicationPlanMapper.convertToDto(medicationPlan);
            List<IntakeInterval> takenIntervals = new ArrayList<>();

            for (MedicationPlanInterval medicationPlanInterval : medicationPlanIntervals) {
                takenIntervals.add(new IntakeInterval(medicationPlanInterval.getIntakeIntervalStart(),
                        medicationPlanInterval.getIntakeIntervalEnd()));
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
                medicationsPlanNotTaken.add(new assignment1.dto.MedicationPlanInterval(medicationPlanDto, toBeTaken));
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

        MedicationPlanInterval medicationPlanInterval = new MedicationPlanInterval(
                medicationPlan,
                new Date(currentDate.getTime()),
                hour,
                intakeInterval.getStartHour(),
                intakeInterval.getEndHour(),
                true
        );


        this.medicationPlanIntervalRepository.save(medicationPlanInterval);
        return medicationPlanDto;
    }


    @Override
    public void patientDidNotTakeMedicationOnTime(MedicationPlanDto medicationPlanDto) {
        this.logger.info(medicationPlanDto.getPatientDto().getUsername() + " did not take his medication at the prescribed time.");
    }

    @Override
    public void patientDidNotTakenMedicationOnTime(MedicationPlanDto medicationPlanDto, IntakeInterval intakeInterval) {
        MedicationPlan medicationPlan = this.medicationPlanRepository.getOne(medicationPlanDto.getId());
        java.util.Date currentDate = new java.util.Date();

        MedicationPlanInterval medicationPlanInterval = new MedicationPlanInterval(
                medicationPlan,
                new Date(currentDate.getTime()),
                currentDate.getHours(),
                intakeInterval.getStartHour(),
                intakeInterval.getEndHour(),
                false
        );

        this.medicationPlanIntervalRepository.save(medicationPlanInterval);
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
