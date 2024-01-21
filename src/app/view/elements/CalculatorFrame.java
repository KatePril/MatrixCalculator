package app.view.elements;

import app.view.elements.panels.CalculatorPanel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CalculatorFrame extends JFrame {

    private final CalculatorPanel panel;

    public CalculatorFrame(String title, HashMap<String, Integer> sizes){
        super(title);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel = new CalculatorPanel(sizes);
        getContentPane().add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public CalculatorPanel getPanel() {
        return panel;
    }
}
