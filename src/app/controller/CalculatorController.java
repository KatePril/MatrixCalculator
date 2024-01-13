package app.controller;

import app.entity.VisualMatrix;
import app.model.CalculatorModel;
import app.utils.StringConstants;
import app.utils.Converter;
import app.utils.HashMapFiller;
import app.utils.Validator;
import app.view.CalculatorView;
import app.view.elements.CalculatorFrame;

import javax.swing.*;
import java.util.HashMap;
import java.util.function.Consumer;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

    private final String[] MATRICES_NAMES = {"MatrixA", "MatrixB", "ResultMatrix"};
    private final String[] ACTION_KEYS = {"Add", "Multiply", "Subtract", "Transpose", "Paste"};

    private HashMap<String, VisualMatrix> matricesHashMap;
    private HashMap<String, JButton> buttonsHashMap;
    private HashMap<String, Consumer<VisualMatrix>> functionsHashMap;

    public CalculatorController(int size) {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView(size);

        fillMatrixHashMap();
        fillButtonHashMap();
        fillFunctionsHashMap();

        addActionListeners();
    }

    private void fillMatrixHashMap() {
        HashMapFiller<String, VisualMatrix> matrixHashMapFiller = new HashMapFiller<>();
        this.matricesHashMap = matrixHashMapFiller.fillNewHashMap(MATRICES_NAMES,
                new VisualMatrix[]{calculatorView.getMatrixA(),
                        calculatorView.getMatrixB(), calculatorView.getResultMatrix()});
    }

    private void fillButtonHashMap() {
        HashMapFiller<String, JButton> buttonHashMapFiller = new HashMapFiller<>();

        String[] buttonKeys = {ACTION_KEYS[0], ACTION_KEYS[1], ACTION_KEYS[2],
                ACTION_KEYS[3] + MATRICES_NAMES[0], ACTION_KEYS[3] + MATRICES_NAMES[1], ACTION_KEYS[3] + MATRICES_NAMES[2],
                ACTION_KEYS[4] + MATRICES_NAMES[0], ACTION_KEYS[4] + MATRICES_NAMES[1]};

        JButton[] buttons = {calculatorView.getAdditionButton(), calculatorView.getMultiplicationButton(),
                calculatorView.getSubtractionButton(), calculatorView.getMatrixATranspositionButton(),
                calculatorView.getMatrixBTranspositionButton(), calculatorView.getResultMatrixTranspositionButton(),
                calculatorView.getPasteMatrixAButton(), calculatorView.getPasteMatrixBButton()};

        this.buttonsHashMap = buttonHashMapFiller.fillNewHashMap(buttonKeys, buttons);
    }

    private void fillFunctionsHashMap() {
        HashMapFiller<String, Consumer<VisualMatrix>> functionsHashMapFiller = new HashMapFiller<>();
        this.functionsHashMap = functionsHashMapFiller.fillNewHashMap(ACTION_KEYS, getFunctionsArray());
    }

    private void addActionListeners() {
        addActionListenerForTwoMatrices(ACTION_KEYS[0]);
        addActionListenerForTwoMatrices(ACTION_KEYS[1]);
        addActionListenerForTwoMatrices(ACTION_KEYS[2]);

        addActionListenerForOneMatrix(ACTION_KEYS[3], MATRICES_NAMES[0]);
        addActionListenerForOneMatrix(ACTION_KEYS[3], MATRICES_NAMES[1]);
        addActionListenerForOneMatrix(ACTION_KEYS[3], MATRICES_NAMES[2]);

        addActionListenerForOneMatrix(ACTION_KEYS[4], MATRICES_NAMES[0]);
        addActionListenerForOneMatrix(ACTION_KEYS[4], MATRICES_NAMES[1]);
    }

    private Consumer<VisualMatrix>[] getFunctionsArray() {
        Consumer<VisualMatrix>[] functions = new Consumer[5];

        functions[0] = (result) -> {
            int[][] matrix = calculatorModel.addMatrices(Converter.convertStringArrayToIntArray(matricesHashMap.get(MATRICES_NAMES[0]).getValues()),
                            Converter.convertStringArrayToIntArray(matricesHashMap.get(MATRICES_NAMES[1]).getValues()));
            result.fillFields(matrix);
        };

        functions[1] = (result) -> {
            int[][] matrix = calculatorModel.multiplyMatrices(Converter.convertStringArrayToIntArray(matricesHashMap.get(MATRICES_NAMES[0]).getValues()),
                            Converter.convertStringArrayToIntArray(matricesHashMap.get(MATRICES_NAMES[1]).getValues()));
            result.fillFields(matrix);
        };

        functions[2] = (result) -> {
            int[][] matrix = calculatorModel.subtractMatrices(Converter.convertStringArrayToIntArray(matricesHashMap.get(MATRICES_NAMES[0]).getValues()),
                            Converter.convertStringArrayToIntArray(matricesHashMap.get(MATRICES_NAMES[1]).getValues()));
            result.fillFields(matrix);
        };

        functions[3] = (matrix) -> matrix.fillFields(calculatorModel.transposeMatrix(
                    Converter.convertStringArrayToIntArray(matrix.getValues())));

        functions[4]= (matrix) -> matrix.fillFields(
                Converter.convertStringArrayToIntArray(matricesHashMap.get(MATRICES_NAMES[2]).getValues()));

        return functions;
    }

    private void addActionListenerForTwoMatrices(String key) {
        buttonsHashMap.get(key).addActionListener(l -> {
            if (Validator.isArrayValid(matricesHashMap.get(MATRICES_NAMES[0]).getValues()) &&
                    Validator.isArrayValid(matricesHashMap.get(MATRICES_NAMES[1]).getValues())) {

                calculatorView.clearLabel();
                functionsHashMap.get(key).accept(matricesHashMap.get(MATRICES_NAMES[2]));

            } else {
                calculatorView.setLabelText(StringConstants.INCORRECT_DATA_MSG);
            }
        });

    }

    private void addActionListenerForOneMatrix(String keyAction, String keyMatrix) {
        buttonsHashMap.get(keyAction+keyMatrix).addActionListener(l -> {
            if (Validator.isArrayValid(matricesHashMap.get(keyMatrix).getValues())) {
                calculatorView.clearLabel();
                functionsHashMap.get(keyAction).accept(matricesHashMap.get(keyMatrix));

            } else {
                calculatorView.setLabelText(StringConstants.INCORRECT_DATA_MSG);
            }
        });
    }

    public JComboBox<Integer> getSizeSelector() {
        return calculatorView.getSizeSelector();
    }

    public CalculatorFrame getCalculatorFrame() {
        return calculatorView.getFrame();
    }
}
