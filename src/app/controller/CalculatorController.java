package app.controller;

import app.entity.VisualMatrix;
import app.enums.Actions;
import app.enums.Matrices;
import app.model.CalculatorModel;
import app.utils.StringConstants;
import app.utils.Converter;
import app.utils.HashMapFiller;
import app.utils.Validator;
import app.view.CalculatorView;
import app.view.elements.CalculatorFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

//    private final String[] MATRICES_NAMES = {"MatrixA", "MatrixB", "ResultMatrix"};
//    private final String[] ACTION_KEYS = {"Add", "Multiply", "Subtract", "Transpose", "Paste"};

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

//        ArrayList<Matrices> matricesKeys = new ArrayList<>(List.of(Matrices.values()));
        ArrayList<String> matricesKeys = new ArrayList<>();
        matricesKeys.add(Matrices.MATRIX_A.name());
        matricesKeys.add(Matrices.MATRIX_B.name());
        matricesKeys.add(Matrices.RESULT_MATRIX.name());


        ArrayList<VisualMatrix> matrices = new ArrayList<>();

        matrices.add(calculatorView.getMatrixA());
        matrices.add(calculatorView.getMatrixB());
        matrices.add(calculatorView.getResultMatrix());

        this.matricesHashMap = matrixHashMapFiller.fillNewHashMap(matricesKeys, matrices);
    }

    private void fillButtonHashMap() {
        HashMapFiller<String, JButton> buttonHashMapFiller = new HashMapFiller<>();

        ArrayList<String> buttonKeys = new ArrayList<>();

        buttonKeys.add(Actions.ADD.name());
        buttonKeys.add(Actions.MULTIPLY.name());
        buttonKeys.add(Actions.SUBTRACT.name());
        buttonKeys.add(Actions.TRANSPOSE.name() + "_" + Matrices.MATRIX_A.name());
        buttonKeys.add(Actions.TRANSPOSE.name() + "_" + Matrices.MATRIX_B.name());
        buttonKeys.add(Actions.TRANSPOSE.name() + "_" + Matrices.RESULT_MATRIX.name());
        buttonKeys.add(Actions.PASTE.name() + "_" + Matrices.MATRIX_A.name());
        buttonKeys.add(Actions.PASTE.name() + "_" + Matrices.MATRIX_B.name());

        ArrayList<JButton> buttons = new ArrayList<>();

        buttons.add(calculatorView.getAdditionButton());
        buttons.add(calculatorView.getMultiplicationButton());
        buttons.add(calculatorView.getSubtractionButton());
        buttons.add(calculatorView.getMatrixATranspositionButton());
        buttons.add(calculatorView.getMatrixBTranspositionButton());
        buttons.add(calculatorView.getResultMatrixTranspositionButton());
        buttons.add(calculatorView.getPasteMatrixAButton());
        buttons.add(calculatorView.getPasteMatrixBButton());

        this.buttonsHashMap = buttonHashMapFiller.fillNewHashMap(buttonKeys, buttons);
    }

    private void fillFunctionsHashMap() {
        HashMapFiller<String, Consumer<VisualMatrix>> functionsHashMapFiller = new HashMapFiller<>();

        ArrayList<String> actionsKeys = new ArrayList<>();
        actionsKeys.add(Actions.ADD.name());
        actionsKeys.add(Actions.MULTIPLY.name());
        actionsKeys.add(Actions.SUBTRACT.name());
        actionsKeys.add(Actions.TRANSPOSE.name());
        actionsKeys.add(Actions.PASTE.name());

        this.functionsHashMap = functionsHashMapFiller.fillNewHashMap(actionsKeys, getFunctionsArrayList());
    }

    private void addActionListeners() {
        addActionListenerForTwoMatrices(Actions.ADD.name());
        addActionListenerForTwoMatrices(Actions.MULTIPLY.name());
        addActionListenerForTwoMatrices(Actions.SUBTRACT.name());

        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), Matrices.MATRIX_A.name());
        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), Matrices.MATRIX_B.name());
        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), Matrices.RESULT_MATRIX.name());

        addActionListenerForOneMatrix(Actions.PASTE.name(), Matrices.MATRIX_A.name());
        addActionListenerForOneMatrix(Actions.PASTE.name(), Matrices.MATRIX_B.name());
    }

    private ArrayList<Consumer<VisualMatrix>> getFunctionsArrayList() {
        ArrayList<Consumer<VisualMatrix>> functions = new ArrayList<>();

        functions.add((result) -> {
                int[][] matrix = calculatorModel.addMatrices(
                        Converter.convertStringArrayToIntArray(matricesHashMap.get(Matrices.MATRIX_A.name()).getValues()),
                        Converter.convertStringArrayToIntArray(matricesHashMap.get(Matrices.MATRIX_B.name()).getValues())
                );
                result.fillFields(matrix);
            }
        );

        functions.add((result) -> {
                int[][] matrix = calculatorModel.multiplyMatrices(
                        Converter.convertStringArrayToIntArray(matricesHashMap.get(Matrices.MATRIX_A.name()).getValues()),
                        Converter.convertStringArrayToIntArray(matricesHashMap.get(Matrices.MATRIX_B.name()).getValues())
                );
                result.fillFields(matrix);
            }
        );

        functions.add((result) -> {
                int[][] matrix = calculatorModel.subtractMatrices(
                        Converter.convertStringArrayToIntArray(matricesHashMap.get(Matrices.MATRIX_A.name()).getValues()),
                        Converter.convertStringArrayToIntArray(matricesHashMap.get(Matrices.MATRIX_B.name()).getValues())
                );
                result.fillFields(matrix);
            }
        );

        functions.add((matrix) -> matrix.fillFields(calculatorModel.transposeMatrix(
                Converter.convertStringArrayToIntArray(matrix.getValues())))
        );

        functions.add((matrix) -> matrix.fillFields(
                Converter.convertStringArrayToIntArray(matricesHashMap.get(Matrices.RESULT_MATRIX.name()).getValues()))
        );

        return functions;
    }

    private void addActionListenerForTwoMatrices(String key) {
        buttonsHashMap.get(key).addActionListener(l -> {
            if (Validator.isArrayValid(matricesHashMap.get(Matrices.MATRIX_A.name()).getValues()) &&
                    Validator.isArrayValid(matricesHashMap.get(Matrices.MATRIX_B.name()).getValues())) {

                calculatorView.clearLabel();
                functionsHashMap.get(key).accept(matricesHashMap.get(Matrices.RESULT_MATRIX.name()));

            } else {
                calculatorView.setLabelText(StringConstants.INCORRECT_DATA_MSG);
            }
        });

    }

    private void addActionListenerForOneMatrix(String keyAction, String keyMatrix) {
        buttonsHashMap.get(keyAction + "_" + keyMatrix).addActionListener(l -> {
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
