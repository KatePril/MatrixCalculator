package app.view.elements.panels;

import app.view.elements.SizeSelector;

import javax.swing.*;
import java.util.HashMap;

public class CalculatorPanel extends JPanel{
    private CalculatorMatrixPanel panel;
    private PastePanel pastePanel;
    private JLabel labelForWarnings;

    public CalculatorPanel(HashMap<String, Integer> sizes) {
        createMatrixPanel(sizes);
        createPastePanel();
        createLabelForWarnings();
    }

    private void createMatrixPanel(HashMap<String, Integer> sizes) {
        panel = new CalculatorMatrixPanel(sizes);
        add(panel);
    }

    private void createPastePanel() {
        pastePanel = new PastePanel();
        add(pastePanel);
    }

    private void createLabelForWarnings() {
        labelForWarnings = new JLabel();
        add(labelForWarnings);
    }

    public void clearLabel() {
        labelForWarnings.setText("");
    }

    public void setLabelText(String text) {
        labelForWarnings.setText(text);
    }

    public void createResultMatrix(int rows, int columns) {
        if (panel.getResultMatrix() != null) {
            panel.getResultMatrix().removeAll();
        }
        panel.createResultMatrix(rows, columns);
        repaint();
    }

    public CalculatorMatrixPanel getPanel() {
        return panel;
    }

    public PastePanel getPastePanel() {
        return pastePanel;
    }
}
