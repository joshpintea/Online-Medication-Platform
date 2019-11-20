package assignment1.dto;

import java.io.Serializable;
import java.util.List;

public class MedicationPlanInterval implements Serializable {
    private MedicationPlanDto medicationPlanDto;
    private List<IntakeInterval> intakeIntervals;

    public MedicationPlanInterval(MedicationPlanDto medicationPlanDto, List<IntakeInterval> intakeIntervals) {
        this.medicationPlanDto = medicationPlanDto;
        this.intakeIntervals = intakeIntervals;
    }

    public MedicationPlanDto getMedicationPlanDto() {
        return medicationPlanDto;
    }

    public void setMedicationPlanDto(MedicationPlanDto medicationPlanDto) {
        this.medicationPlanDto = medicationPlanDto;
    }

    public List<IntakeInterval> getIntakeIntervals() {
        return intakeIntervals;
    }

    public void setIntakeIntervals(List<IntakeInterval> intakeIntervals) {
        this.intakeIntervals = intakeIntervals;
    }
}
