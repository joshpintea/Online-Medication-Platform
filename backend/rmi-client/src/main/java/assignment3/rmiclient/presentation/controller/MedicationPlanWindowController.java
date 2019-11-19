package assignment3.rmiclient.presentation.controller;

import assignment1.dto.MedicationPlanDto;
import assignment1.service.pildispenser.PillDispenser;
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

    private final String cronTask = "0 5 0 * * *";

    private PillDispenser pillDispenser;
    private MedicationPlanWindow medicationPlanWindow;
    private Properties properties;
    private View view;
    private Long patientId;

    private List<Pair<MedicationPlanDto, Pair<Integer, Integer>>> medicationsPlan;

    public MedicationPlanWindowController(PillDispenser pillDispenser, MedicationPlanWindow medicationPlanWindow, Properties properties, View view) {
        this.pillDispenser = pillDispenser;
        this.medicationPlanWindow = medicationPlanWindow;
        this.properties = properties;
        this.view = view;

        this.patientId = new Long(properties.getProperty("patient_id"));
        this.getMedicationPlans();
    }

    private void updateWindow() {
        this.medicationPlanWindow.clearWindow();

        for (Pair<MedicationPlanDto, Pair<Integer, Integer>> medicationPlan: this.medicationsPlan) {
                MedicationPlanComponent medicationPlanComponent = new MedicationPlanComponent(medicationPlan.getKey(), medicationPlan.getValue());
                medicationPlanComponent.addActionListener(new TakeMedication(medicationPlan.getKey(), medicationPlan.getValue()));

                this.medicationPlanWindow.addMedicationPlanComponent(medicationPlanComponent);
        }
    }

    private List<Pair<Integer, Integer>> computeIntakeIntervals(MedicationPlanDto medicationPlanDto) {
        java.util.Date currentDate = new java.util.Date();
        int hour = currentDate.getHours();

        List<Pair<Integer, Integer>> intakeIntervals = new ArrayList<>();
        for (int i = 0; i < 24 / medicationPlanDto.getIntakeInterval() + 1; i++) {
            if (i % 2 == 0) {
                int start = i * medicationPlanDto.getIntakeInterval();
                int end = (i+1) * medicationPlanDto.getIntakeInterval() - 1;
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

    @Scheduled(cron = cronTask)
    private void getMedicationPlans() {
        List<MedicationPlanDto> medicationPlanDtos = this.pillDispenser.getNotTakenMedicationPlans(this.patientId);

        this.medicationsPlan = new ArrayList<>();
        for (MedicationPlanDto medicationPlan: medicationPlanDtos) {
            List<Pair<Integer, Integer>> intakeIntervals = this.computeIntakeIntervals(medicationPlan);

            for (Pair<Integer, Integer> interval: intakeIntervals) {
                this.medicationsPlan.add(new Pair<>(medicationPlan, interval));
            }

        }
        this.updateWindow();
    }

    @Scheduled(fixedRate = 3600000) // 1000 * 60 * 60(ms) = 1h
    private void checkNotTakenMedication() {
        java.util.Date currentDate = new java.util.Date();
        int hour = currentDate.getHours();

        List<Pair<MedicationPlanDto, Pair<Integer, Integer>>> newMedicationsPlan = new ArrayList<>();
        for (Pair<MedicationPlanDto, Pair<Integer, Integer>> medicationPlanAndInterval: this.medicationsPlan) {
            Pair<Integer, Integer> interval = medicationPlanAndInterval.getValue();

            if (hour > interval.getValue()) {
                this.pillDispenser.getNotTakenMedicationPlans(medicationPlanAndInterval.getKey().getPatientDto().getId());
                continue;
            }

            newMedicationsPlan.add(medicationPlanAndInterval);
        }

        this.medicationsPlan = newMedicationsPlan;
        this.updateWindow();
    }

    private class TakeMedication implements ActionListener {
        private MedicationPlanDto medicationPlanDto;
        private Pair<Integer, Integer> interval;

        public TakeMedication(MedicationPlanDto medicationPlanDto, Pair<Integer, Integer> interval) {
            this.medicationPlanDto = medicationPlanDto;
            this.interval = interval;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                pillDispenser.takeMedication(medicationPlanDto, this.interval);

                // remove medication plan with the given interval
                List<Pair<MedicationPlanDto, Pair<Integer, Integer>>> newMedicationsPlan = new ArrayList<>();
                for (Pair<MedicationPlanDto, Pair<Integer, Integer>> medicationPlanAndInterval: medicationsPlan) {
                    if (!(medicationPlanAndInterval.getKey().getId().equals(medicationPlanDto.getId()) && this.interval == medicationPlanAndInterval.getValue())) {
                        newMedicationsPlan.add(medicationPlanAndInterval);
                    }
                }

                medicationsPlan = newMedicationsPlan;
                updateWindow();


            } catch (Exception ex) {
                view.showError(ex.getMessage(), "Error");
            }
            System.out.println(medicationPlanDto.getId() + ", " + this.interval);
        }
    }
}
