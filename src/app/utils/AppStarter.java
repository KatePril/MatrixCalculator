package app.utils;

import app.controller.CalculatorController;

public class AppStarter {
    private CalculatorController calculatorController;
    public AppStarter() {
        calculatorController = new CalculatorController(2, this);
    }

    public void setCalculatorController(int size, AppStarter appStarter) {
        this.calculatorController = new CalculatorController(size, appStarter);
    }
}
