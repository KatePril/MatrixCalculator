package app.view.elements.panels;

import app.view.elements.SizeSelector;

import javax.swing.*;
import java.util.HashMap;

public class CalculatorPanel extends JPanel{
//    private JComboBox<Integer> sizeSelector;
    private CalculatorMatrixPanel panel;
    private PastePanel pastePanel;
    private JLabel labelForWarnings;

    public CalculatorPanel(HashMap<String, Integer> sizes) {
//        createSizeSelector(size);
        createMatrixPanel(sizes);
        createPastePanel();
        createLabelForWarnings();
    }

//    private void createSizeSelector(int size) {
//        sizeSelector = new SizeSelector(size);
//        add(sizeSelector);
//    }

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

//    public JComboBox<Integer> getSizeSelector() {
//        return sizeSelector;
//    }

    public CalculatorMatrixPanel getPanel() {
        return panel;
    }

    public PastePanel getPastePanel() {
        return pastePanel;
    }
}
