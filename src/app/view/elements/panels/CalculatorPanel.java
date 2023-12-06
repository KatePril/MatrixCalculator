package app.view.elements.panels;

import javax.swing.*;

public class CalculatorPanel extends JPanel{
    private JComboBox<Integer> sizeSelector;
    private CalculatorMatrixPanel panel;

    public CalculatorPanel() {
        createSizeSelector();
        createMatrixPanel();
    }

    private void createSizeSelector() {
        sizeSelector = new JComboBox<>(new Integer[]{2, 3, 4, 5});
        add(sizeSelector);
    }

    private void createMatrixPanel() {
        panel = new CalculatorMatrixPanel();
        add(panel);
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
}
