package app.view;

import app.view.elements.CalculatorFrame;
import app.view.elements.panels.CalculatorMatrixPanel;
import app.view.elements.panels.CalculatorPanel;

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

        panel.getSizeSelector().addActionListener(l -> panel.getPanel().changeSize((Integer) panel.getSizeSelector().getSelectedItem()));

        frame.getContentPane().add(panel, BorderLayout.CENTER);


    }
}
