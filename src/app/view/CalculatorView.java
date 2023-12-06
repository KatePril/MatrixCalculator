package app.view;

import app.view.elements.CalculatorFrame;
import app.view.elements.panels.ActionButtonsPanel;
import app.view.elements.panels.CalculatorPanel;
import app.view.elements.panels.ResultPanel;
import app.view.elements.panels.TranspositionPanel;

import javax.swing.*;
import java.awt.*;

public class CalculatorView {
    CalculatorFrame frame;
    public CalculatorPanel panel;
    public void drawCalculator() {
        createFrame();
        fillFrame();

        frame.setVisible(true);
    }

    private void createFrame() {
        frame = new CalculatorFrame("Calculator");
    }

    private void fillFrame() {
        panel = new CalculatorPanel();

        frame.getContentPane().add(panel, BorderLayout.CENTER);


    }
}
