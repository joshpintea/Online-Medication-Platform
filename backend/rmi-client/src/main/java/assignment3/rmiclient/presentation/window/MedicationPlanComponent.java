package assignment3.rmiclient.presentation.window;

import assignment1.dto.DrugDto;
import assignment1.dto.IntakeInterval;
import assignment1.dto.MedicationPlanDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MedicationPlanComponent extends JPanel {

    private IntakeInterval interval;
    private MedicationPlanDto medicationPlanDto;
    private JButton takeMedications = new JButton("Take medications");

    public MedicationPlanComponent(MedicationPlanDto medicationPlanDto, IntakeInterval interval) {
        this.medicationPlanDto = medicationPlanDto;
        this.interval = interval;
        this.initialize();
    }

    public void addActionListener(ActionListener actionListener) {
        this.takeMedications.addActionListener(actionListener);
    }

    private void initialize() {
        StringBuilder medicationsListAsString = new StringBuilder();

        for (DrugDto drugDto: this.medicationPlanDto.getDrugsList()) {
            medicationsListAsString.append("* ").append(drugDto.getName()).append(" - ").append(drugDto.getDosage()).append(" ");
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(new Dimension(200, 200));
        this.add(new JLabel("Id: " + this.medicationPlanDto.getId()));
        this.add(new JLabel("Start date: " + this.medicationPlanDto.getStartDate()));
        this.add(new JLabel("End date: " + this.medicationPlanDto.getStartDate()));
        this.add(new JLabel("List of medications: " + medicationsListAsString.toString()));
        this.add(new JLabel("Interval: " + this.interval.getStartHour() + "-" + this.interval.getEndHour()));

        this.add(takeMedications);
    }
}
