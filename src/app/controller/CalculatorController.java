package app.controller;

import app.model.CalculatorModel;
import app.utils.Constants;
import app.utils.Converter;
import app.utils.Validator;
import app.view.CalculatorView;

import javax.swing.*;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView();

        addMatrix();
        multiplyMatrix();
        subtractMatrix();
        transposeMatrixA();
        transposeMatrixB();
        transposeResultMatrix();
        changeSize();
    }

    private void changeSize() {
        calculatorView.getSizeSelector().addItemListener(l -> {
            calculatorView.getMatrixPanel().changeSize((Integer) calculatorView.getSizeSelector().getSelectedItem());
            calculatorView.getFrame().repaint();
        });
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

    private void subtractMatrix() {
        calculatorView.getSubtractionButton().addActionListener(l -> {
            if (Validator.isArrayValid(calculatorView.getMatrixAFields())) {
                if (Validator.isArrayValid(calculatorView.getMatrixBFields())) {
                    calculatorView.clearLabel();

                    int[][] matrixAValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixAFields());
                    int[][] matrixBValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixBFields());

                    calculatorView.setResultMatrixFields(calculatorModel.getMatrixSubtracter().subtractMatrix(matrixAValues, matrixBValues));
                } else {
                    calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
                }
            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });
    }

    private void transposeMatrixA() {
        calculatorView.getMatrixATranspositionButton().addActionListener(l -> {
            if (Validator.isArrayValid(calculatorView.getMatrixAFields())) {
                calculatorView.clearLabel();

                int[][] matrixAValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixAFields());

                calculatorView.setMatrixAFields(calculatorModel.getMatrixTransposer().transposeMatrix(matrixAValues));
            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });
    }

    private void transposeMatrixB() {
        calculatorView.getMatrixBTranspositionButton().addActionListener(l -> {
            if (Validator.isArrayValid(calculatorView.getMatrixBFields())) {
                calculatorView.clearLabel();

                int[][] matrixBValues = Converter.convertStringArrayToIntegerArray(calculatorView.getMatrixBFields());

                calculatorView.setMatrixBFields(calculatorModel.getMatrixTransposer().transposeMatrix(matrixBValues));
            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });
    }

    private void transposeResultMatrix() {
        calculatorView.getResultMatrixTranspositionButton().addActionListener(l -> {
            if (Validator.isArrayValid(calculatorView.getResultMatrixFields())) {
                calculatorView.clearLabel();

                int[][] resultMatrixValues = Converter.convertStringArrayToIntegerArray(calculatorView.getResultMatrixFields());

                calculatorView.setResultMatrixFields(calculatorModel.getMatrixTransposer().transposeMatrix(resultMatrixValues));
            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });
    }


}
