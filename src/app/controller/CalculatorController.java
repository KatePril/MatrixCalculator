package app.controller;

import app.controller.functions.Predicate;
import app.entity.VisualMatrix;
import app.model.CalculatorModel;
import app.utils.Constants;
import app.utils.Converter;
import app.utils.Validator;
import app.view.CalculatorView;

import javax.swing.*;
import java.util.HashMap;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    private HashMap<String, VisualMatrix> matrixHashMap;
    private HashMap<String, JButton> buttonHashMap;
    private HashMap<String, Predicate<VisualMatrix>> functionsHashMap;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView();
        this.matrixHashMap = new HashMap<>();
        this.buttonHashMap = new HashMap<>();
        this.functionsHashMap = new HashMap<>();

        fillMatrixHashMap();
        fillButtonHashMap();
        fillFunctionsHashMap();

        changeSize();

        twoMatrixActionListener("Add");
        twoMatrixActionListener("Multiply");
        twoMatrixActionListener("Subtract");

        oneMatrixActionListener("Transpose", "MatrixA");
        oneMatrixActionListener("Transpose", "MatrixB");
        oneMatrixActionListener("Transpose", "ResultMatrix");
    }

    private void fillMatrixHashMap() {
        matrixHashMap.put("MatrixA", calculatorView.getMatrixA());
        matrixHashMap.put("MatrixB", calculatorView.getMatrixB());
        matrixHashMap.put("ResultMatrix", calculatorView.getResultMatrix());
    }

    private void fillButtonHashMap() {
        buttonHashMap.put("Add", calculatorView.getAdditionButton());
        buttonHashMap.put("Multiply", calculatorView.getMultiplicationButton());
        buttonHashMap.put("Subtract", calculatorView.getSubtractionButton());
        buttonHashMap.put("TransposeMatrixA", calculatorView.getMatrixATranspositionButton());
        buttonHashMap.put("TransposeMatrixB", calculatorView.getMatrixBTranspositionButton());
        buttonHashMap.put("TransposeResultMatrix", calculatorView.getResultMatrixTranspositionButton());
    }

    private void fillFunctionsHashMap() {
        Predicate<VisualMatrix> add = (result) -> {
            int[][] matrix = calculatorModel.getMatrixAdder().addMatrix(Converter.convertStringArrayToIntegerArray(matrixHashMap.get("MatrixA").getValues()),
                    Converter.convertStringArrayToIntegerArray(matrixHashMap.get("MatrixB").getValues()));
            result.fillFields(matrix);
        };
        functionsHashMap.put("Add", add);

        Predicate<VisualMatrix> multiply = (result) -> {
            int[][] matrix = calculatorModel.getMatrixMultiplier().multiplyMatrix(Converter.convertStringArrayToIntegerArray(matrixHashMap.get("MatrixA").getValues()),
                    Converter.convertStringArrayToIntegerArray(matrixHashMap.get("MatrixB").getValues()));
            result.fillFields(matrix);
        };
        functionsHashMap.put("Multiply", multiply);

        Predicate<VisualMatrix> subtract = (result) -> {
            int[][] matrix = calculatorModel.getMatrixSubtracter().subtractMatrix(Converter.convertStringArrayToIntegerArray(matrixHashMap.get("MatrixA").getValues()),
                    Converter.convertStringArrayToIntegerArray(matrixHashMap.get("MatrixB").getValues()));
            result.fillFields(matrix);
        };
        functionsHashMap.put("Subtract", subtract);

        Predicate<VisualMatrix> transpose = (matrix) -> {
            matrix.fillFields(calculatorModel.getMatrixTransposer().transposeMatrix(
                    Converter.convertStringArrayToIntegerArray(matrix.getValues())));
        };
        functionsHashMap.put("Transpose", transpose);
    }

    private void twoMatrixActionListener(String key) {
        buttonHashMap.get(key).addActionListener(l -> {
            if (Validator.isArrayValid(matrixHashMap.get("MatrixA").getValues()) &&
                    Validator.isArrayValid(matrixHashMap.get("MatrixB").getValues())) {

                calculatorView.clearLabel();
                functionsHashMap.get(key).apply(matrixHashMap.get("ResultMatrix"));

            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });

    }

    private void oneMatrixActionListener(String keyAction, String keyMatrix) {
        buttonHashMap.get(keyAction+keyMatrix).addActionListener(l -> {
            if (Validator.isArrayValid(matrixHashMap.get(keyMatrix).getValues())) {

                calculatorView.clearLabel();
                functionsHashMap.get(keyAction).apply(matrixHashMap.get(keyMatrix));

            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });
    }


    private void changeSize() {
        calculatorView.getSizeSelector().addItemListener(l -> {
            calculatorView.getMatrixPanel().changeSize((Integer) calculatorView.getSizeSelector().getSelectedItem());
            calculatorView.getFrame().repaint();
        });
    }


}
