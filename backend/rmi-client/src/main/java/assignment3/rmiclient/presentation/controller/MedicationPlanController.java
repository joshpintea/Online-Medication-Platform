package assignment3.rmiclient.presentation.controller;

import assignment3.rmiclient.presentation.window.MedicationPlanWindow;
import org.springframework.stereotype.Component;

@Component
public class MedicationPlanController {

    private MedicationPlanWindow medicationPlanWindow;

    public MedicationPlanController(MedicationPlanWindow medicationPlanWindow) {
        this.medicationPlanWindow = medicationPlanWindow;
    }


}
