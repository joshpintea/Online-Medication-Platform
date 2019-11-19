package assignment3.rmiclient.presentation.window;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MedicationPlanWindow extends JPanel {

    private JPanel window = new JPanel();

    public MedicationPlanWindow() {
        this.initialize();
    }

    private void initialize() {
        this.setWindowLayout();
        this.add(window);
    }

    public void addMedicationPlanComponent(MedicationPlanComponent medicationPlanComponent) {
        this.window.add(medicationPlanComponent);
        this.window.revalidate();
    }

    public void clearWindow() {
        this.window.removeAll();
        this.window.revalidate();
    }


    private void setWindowLayout() {
        GridLayout gridLayout = new GridLayout(0, 3);
        this.window.setLayout(gridLayout);
    }
}
