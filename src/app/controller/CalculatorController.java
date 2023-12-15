package app.controller;

import app.model.CalculatorModel;
import app.utils.Constants;
import app.utils.Converter;
import app.utils.Validator;
import app.view.CalculatorView;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView();

        addMatrix();
        multiplyMatrix();
    }

    private void addMatrix() {
        calculatorView.getAdditionButton().addActionListener(l -> {
            if (Validator.isArrayValid(calculatorView.getMatrixAFields())) {
                if (Validator.isArrayValid(calculatorView.getMatrixBFields())) {
                    calculatorView.clearLabel();

                    int[][] matrixAValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixAFields());
                    int[][] matrixBValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixBFields());

                    calculatorView.setResultMatrixFields(calculatorModel.getMatrixAdder().addMatrix(matrixAValues, matrixBValues));
                } else {
                    calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
                }
            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });
    }

    private void multiplyMatrix() {
        calculatorView.getMultiplicationButton().addActionListener(l -> {
            if (Validator.isArrayValid(calculatorView.getMatrixAFields())) {
                if (Validator.isArrayValid(calculatorView.getMatrixBFields())) {
                    calculatorView.clearLabel();

                    int[][] matrixAValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixAFields());
                    int[][] matrixBValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixBFields());

                    calculatorView.setResultMatrixFields(calculatorModel.getMatrixMultiplier().multiplyMatrix(matrixAValues, matrixBValues));
                } else {
                    calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
                }
            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });
    }

}
