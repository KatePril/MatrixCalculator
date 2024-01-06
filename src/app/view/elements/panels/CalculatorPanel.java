package app.view.elements.panels;

import javax.swing.*;

public class CalculatorPanel extends JPanel{
    private JComboBox<Integer> sizeSelector;
    private CalculatorMatrixPanel panel;
    private PastePanel pastePanel;
    private JLabel labelForWarnings;

    public CalculatorPanel(int size) {
        createSizeSelector(size);
        createMatrixPanel(size);
        createPastePanel();
        createLabelForWarnings();
    }

    private void createSizeSelector(int size) {
        sizeSelector = new JComboBox<>(new Integer[]{2, 3, 4, 5});
        sizeSelector.setSelectedItem(size);
        add(sizeSelector);
    }

    private void createMatrixPanel(int size) {
        panel = new CalculatorMatrixPanel(size);
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

    public JComboBox<Integer> getSizeSelector() {
        return sizeSelector;
    }

    public void setSizeSelector(JComboBox<Integer> sizeSelector) {
        this.sizeSelector = sizeSelector;
    }

    public CalculatorMatrixPanel getPanel() {
        return panel;
    }

    public void setPanel(CalculatorMatrixPanel panel) {
        this.panel = panel;
    }

    public PastePanel getPastePanel() {
        return pastePanel;
    }

    public void setPastePanel(PastePanel pastePanel) {
        this.pastePanel = pastePanel;
    }

    public JLabel getLabelForWarnings() {
        return labelForWarnings;
    }

    public void setLabelForWarnings(JLabel labelForWarnings) {
        this.labelForWarnings = labelForWarnings;
    }
}
