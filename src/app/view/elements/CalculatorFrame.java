package app.view.elements;

import app.view.elements.panels.CalculatorPanel;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private final CalculatorPanel panel;

    public CalculatorFrame(String title, int size){
        super(title);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel = new CalculatorPanel(size);
        getContentPane().add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public CalculatorPanel getPanel() {
        return panel;
    }
}
