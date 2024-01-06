package app.utils;

import app.controller.CalculatorController;

import javax.swing.*;

public class AppStarter {
    private CalculatorController calculatorController;
    private JComboBox<Integer> sizeSelector;
    public AppStarter() {
        calculatorController = new CalculatorController(2);
        sizeSelector = calculatorController.getSizeSelector();
        changeSize();
    }

    public void setCalculatorController(int size) {
        this.calculatorController = new CalculatorController(size);
    }

    private void deleteFrame() {
        if (calculatorController.getCalculatorFrame() != null) {
            calculatorController.getCalculatorFrame().setVisible(false);
            calculatorController.getCalculatorFrame().dispose();
        }
    }

    private void changeSize() {
        sizeSelector.addItemListener(l -> {
            deleteFrame();
            this.calculatorController = new CalculatorController((Integer) sizeSelector.getSelectedItem());
        });
    }
}
