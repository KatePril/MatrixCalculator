package app.controller;

public class SizeController {
    private CalculatorController calculatorController;

    public SizeController() {
        calculatorController = new CalculatorController(2);
        changeSize();
    }

    private void deleteFrame() {
        if (calculatorController.getCalculatorFrame() != null) {
            calculatorController.getCalculatorFrame().setVisible(false);
            calculatorController.getCalculatorFrame().dispose();
        }
    }

    private void changeSize() {
        calculatorController.getSizeSelector().addItemListener(l -> {
            deleteFrame();
            int selectorValue = (Integer) calculatorController.getSizeSelector().getSelectedItem();
            this.calculatorController = new CalculatorController(selectorValue);
            changeSize();
        });
    }
}
