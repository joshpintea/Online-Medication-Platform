package assignment3.rmiclient.presentation.controller;

import assignment1.dto.IntakeInterval;
import assignment1.dto.MedicationPlanDto;
import assignment1.dto.MedicationPlanInterval;
import assignment1.service.pildispenser.PillDispenserService;
import assignment3.rmiclient.presentation.View;
import assignment3.rmiclient.presentation.window.MedicationPlanComponent;
import assignment3.rmiclient.presentation.window.MedicationPlanWindow;
import javafx.util.Pair;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class MedicationPlanWindowController {

    private final String cronTask = "0 15 * * * *"; // "0 0 0 * * * on each day at 0 AM

    private PillDispenserService pillDispenserService;
    private MedicationPlanWindow medicationPlanWindow;
    private Properties properties;
    private View view;
    private Long patientId;

    private List<Pair<MedicationPlanDto, IntakeInterval>> medicationsPlan;

    public MedicationPlanWindowController(PillDispenserService pillDispenserService, MedicationPlanWindow medicationPlanWindow, Properties properties, View view) {
        this.pillDispenserService = pillDispenserService;
        this.medicationPlanWindow = medicationPlanWindow;
        this.properties = properties;
        this.view = view;

        this.patientId = new Long(properties.getProperty("patient_id"));
        this.getMedicationPlans();
    }

    private void updateWindow() {
        this.medicationPlanWindow.clearWindow();

        for (Pair<MedicationPlanDto, IntakeInterval> medicationPlan: this.medicationsPlan) {
                MedicationPlanComponent medicationPlanComponent = new MedicationPlanComponent(medicationPlan.getKey(), medicationPlan.getValue());
                medicationPlanComponent.addActionListener(new TakeMedication(medicationPlan.getKey(), medicationPlan.getValue()));

                this.medicationPlanWindow.addMedicationPlanComponent(medicationPlanComponent);
        }
    }

    @Scheduled(cron = cronTask)
    private void getMedicationPlans() {
        List<MedicationPlanInterval> notTakenMedicationPlans = new ArrayList<>();
        try {
            notTakenMedicationPlans = this.pillDispenserService.getNotTakenMedicationPlans(this.patientId);
        } catch (Exception ex) {
            this.view.showError(ex.getMessage(), "error");
            System.exit(-1);
        }

        this.medicationsPlan = new ArrayList<>();
        for (MedicationPlanInterval medicationPlanInterval: notTakenMedicationPlans) {

            for (IntakeInterval intakeInterval: medicationPlanInterval.getIntakeIntervals()) {
                this.medicationsPlan.add(new Pair<>(medicationPlanInterval.getMedicationPlanDto(), intakeInterval));
            }

        }
        this.updateWindow();
    }

    @Scheduled(fixedRate = 3600000) // 1000 * 60 * 60(ms) = 1h = 3600000
    private void checkNotTakenMedication() {
        java.util.Date currentDate = new java.util.Date();
        int hour = currentDate.getHours();

        List<Pair<MedicationPlanDto, IntakeInterval>> newMedicationsPlan = new ArrayList<>();
        for (Pair<MedicationPlanDto, IntakeInterval> medicationPlanAndInterval: this.medicationsPlan) {
            IntakeInterval interval = medicationPlanAndInterval.getValue();

            if (hour > interval.getEndHour()) {
                this.pillDispenserService.patientDidNotTakeMedicationOnTime(medicationPlanAndInterval.getKey());
                this.pillDispenserService.patientDidNotTakenMedicationOnTime(medicationPlanAndInterval.getKey(), medicationPlanAndInterval.getValue());
                continue;
            }

            newMedicationsPlan.add(medicationPlanAndInterval);
        }

        this.medicationsPlan = newMedicationsPlan;
        this.updateWindow();
    }

    private class TakeMedication implements ActionListener {
        private MedicationPlanDto medicationPlanDto;
        private IntakeInterval interval;

        public TakeMedication(MedicationPlanDto medicationPlanDto, IntakeInterval interval) {
            this.medicationPlanDto = medicationPlanDto;
            this.interval = interval;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                pillDispenserService.takeMedication(medicationPlanDto, this.interval);

                // remove medication plan with the given interval
                List<Pair<MedicationPlanDto, IntakeInterval>> newMedicationsPlan = new ArrayList<>();
                for (Pair<MedicationPlanDto, IntakeInterval> medicationPlanAndInterval: medicationsPlan) {
                    if (!(medicationPlanAndInterval.getKey().getId().equals(medicationPlanDto.getId())
                            && this.interval.getStartHour() == medicationPlanAndInterval.getValue().getStartHour()
                            && this.interval.getEndHour() == medicationPlanAndInterval.getValue().getEndHour())) {
                        newMedicationsPlan.add(medicationPlanAndInterval);
                    }
                }

                medicationsPlan = newMedicationsPlan;
                updateWindow();


            } catch (Exception ex) {
                view.showError(ex.getMessage(), "Error");
            }
        }
    }
}
