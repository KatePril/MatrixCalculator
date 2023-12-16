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
import java.util.function.Consumer;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    private final String[] MATRIX_NAMES = {"MatrixA", "MatrixB", "ResultMatrix"};
    private final String[] ACTION_KEYS = {"Add", "Multiply", "Subtract", "Transpose"};

    private HashMap<String, VisualMatrix> matrixHashMap;
    private HashMap<String, JButton> buttonHashMap;
    private HashMap<String, Consumer<VisualMatrix>> functionsHashMap;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView();

        HashMapFiller<String, VisualMatrix> matrixHashMapFiller = new HashMapFiller<>();
        this.matrixHashMap = matrixHashMapFiller.fillNewHashMap(MATRIX_NAMES,
                new VisualMatrix[]{calculatorView.getMatrixA(), calculatorView.getMatrixB(), calculatorView.getResultMatrix()});

        HashMapFiller<String, JButton> buttonHashMapFiller = new HashMapFiller<>();
        String[] buttonKeys = {ACTION_KEYS[0], ACTION_KEYS[1], ACTION_KEYS[2],
                ACTION_KEYS[3]+MATRIX_NAMES[0], ACTION_KEYS[3]+MATRIX_NAMES[1], ACTION_KEYS[3]+MATRIX_NAMES[2]};
        JButton[] buttons = {calculatorView.getAdditionButton(), calculatorView.getMultiplicationButton(),
                calculatorView.getSubtractionButton(), calculatorView.getMatrixATranspositionButton(),
                calculatorView.getMatrixBTranspositionButton(), calculatorView.getResultMatrixTranspositionButton()};

        this.buttonHashMap = buttonHashMapFiller.fillNewHashMap(buttonKeys, buttons);

        HashMapFiller<String, Consumer<VisualMatrix>> functionsHashMapFiller = new HashMapFiller<>();
        this.functionsHashMap = functionsHashMapFiller.fillNewHashMap(ACTION_KEYS, getFunctionsArray());

        changeSize();

        twoMatrixActionListener(ACTION_KEYS[0]);
        twoMatrixActionListener(ACTION_KEYS[1]);
        twoMatrixActionListener(ACTION_KEYS[2]);

        oneMatrixActionListener(ACTION_KEYS[3], MATRIX_NAMES[0]);
        oneMatrixActionListener(ACTION_KEYS[3], MATRIX_NAMES[1]);
        oneMatrixActionListener(ACTION_KEYS[3], MATRIX_NAMES[2]);
    }

    private Consumer<VisualMatrix>[] getFunctionsArray() {
        Consumer<VisualMatrix>[] functions = new Consumer[4];
        functions[0] = (result) -> {
            int[][] matrix = calculatorModel.getMatrixAdder()
                    .addMatrix(Converter.convertStringArrayToIntegerArray(matrixHashMap.get(MATRIX_NAMES[0]).getValues()),
                    Converter.convertStringArrayToIntegerArray(matrixHashMap.get(MATRIX_NAMES[1]).getValues()));
            result.fillFields(matrix);
        };

        functions[1] = (result) -> {
            int[][] matrix = calculatorModel.getMatrixMultiplier()
                    .multiplyMatrix(Converter.convertStringArrayToIntegerArray(matrixHashMap.get(MATRIX_NAMES[0]).getValues()),
                    Converter.convertStringArrayToIntegerArray(matrixHashMap.get(MATRIX_NAMES[1]).getValues()));
            result.fillFields(matrix);
        };

        functions[2] = (result) -> {
            int[][] matrix = calculatorModel.getMatrixSubtracter()
                    .subtractMatrix(Converter.convertStringArrayToIntegerArray(matrixHashMap.get(MATRIX_NAMES[0]).getValues()),
                    Converter.convertStringArrayToIntegerArray(matrixHashMap.get(MATRIX_NAMES[1]).getValues()));
            result.fillFields(matrix);
        };

        functions[3] = (matrix) -> {
            matrix.fillFields(calculatorModel.getMatrixTransposer().transposeMatrix(
                    Converter.convertStringArrayToIntegerArray(matrix.getValues())));
        };

        return functions;
    }

    private void twoMatrixActionListener(String key) {
        buttonHashMap.get(key).addActionListener(l -> {
            if (Validator.isArrayValid(matrixHashMap.get(MATRIX_NAMES[0]).getValues()) &&
                    Validator.isArrayValid(matrixHashMap.get(MATRIX_NAMES[1]).getValues())) {

                calculatorView.clearLabel();
                functionsHashMap.get(key).accept(matrixHashMap.get(MATRIX_NAMES[2]));

            } else {
                calculatorView.setLabelText(Constants.INCORRECT_DATA_MSG);
            }
        });

    }

    private void oneMatrixActionListener(String keyAction, String keyMatrix) {
        buttonHashMap.get(keyAction+keyMatrix).addActionListener(l -> {
            if (Validator.isArrayValid(matrixHashMap.get(keyMatrix).getValues())) {

                calculatorView.clearLabel();
                functionsHashMap.get(keyAction).accept(matrixHashMap.get(keyMatrix));

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
