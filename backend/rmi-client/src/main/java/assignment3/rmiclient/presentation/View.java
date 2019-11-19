package assignment3.rmiclient.presentation;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class View extends JFrame {

    public View() {
        super();
        this.initialize();
    }

    public void setWindow(JPanel window) {
        this.setContentPane(window);
        this.invalidate ();
        this.validate ();
        this.repaint ();
    }

    public void showError(String message, String title) {
        JOptionPane.showMessageDialog (null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public void showInfo(String message, String title) {
        JOptionPane.showMessageDialog (null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void initialize() {
        this.setSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Medication platform");
        this.setLocationRelativeTo (null);
        this.setVisible(true);
    }
}
