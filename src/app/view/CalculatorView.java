package app.view;

import app.view.elements.ActionButton;
import app.view.elements.CalculatorFrame;
import app.view.elements.panels.ActionButtonsPanel;
import app.view.elements.panels.MatrixPanel;
import app.view.elements.panels.ResultPanel;
import app.view.elements.panels.TranspositionPanel;

import javax.swing.*;
import java.awt.*;

public class CalculatorView {
    CalculatorFrame frame;
    JPanel mainPanel;
    public void drawCalculator() {
        createFrame();
        fillFrame();

        frame.setVisible(true);
    }

    private void createFrame() {
        frame = new CalculatorFrame("Calculator");
    }

    private void fillFrame() {
        mainPanel = new JPanel();

        drawTranspositionPanel(4);
        drawActionButtonsPanel();
        drawTranspositionPanel(4);
        drawResultPanel(4);

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void drawResultPanel(int size) {
        ResultPanel panel = new ResultPanel(size);
        mainPanel.add(panel);
    }

    private void drawTranspositionPanel(int size) {
        TranspositionPanel panel = new TranspositionPanel(size);
        mainPanel.add(panel);
    }

    private void drawActionButtonsPanel() {
        ActionButtonsPanel panel = new ActionButtonsPanel();
        mainPanel.add(panel);
    }
}
