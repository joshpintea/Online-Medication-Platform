package assignment3.rmiclient.presentation.window;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class MedicationPlanWindow extends JPanel {

    private JTable medicationPlanTable = new JTable();

    public MedicationPlanWindow() {
        this.initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Your medication plan"));
        panel.add(this.medicationPlanTable);

        this.add(medicationPlanTable);
    }


}
