package app.controller;

import app.controller.utils.HashMapsGenerator;
import app.controller.utils.NoArgumentFunction;
import app.entity.VisualMatrix;
import app.enums.Actions;
import app.enums.Matrices;
import app.model.CalculatorModel;
import app.utils.StringConstants;
import app.utils.Validator;
import app.view.CalculatorView;
import app.view.elements.CalculatorFrame;

import javax.swing.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

    private final HashMap<String, VisualMatrix> matricesHashMap;
    private final HashMap<String, JButton> buttonsHashMap;
    private final HashMap<String, NoArgumentFunction<Integer[][]>> noArgFunctionshashMap;

    private final HashMap<String, Function<VisualMatrix, Integer[][]>> argFunctionshashMap;
    private final HashMap<String, Consumer<VisualMatrix>> functionsHashMap;
    private final HashMap<String, JTextField> inputsHashMap;
    private final HashMap<String, BiConsumer<VisualMatrix, String>> biFunctionsHashMap;


    public CalculatorController(HashMap<String, Integer> sizes) {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView(sizes);

        this.matricesHashMap = HashMapsGenerator.getMatricesHashMap(calculatorView);
        this.buttonsHashMap = HashMapsGenerator.getButtonsHashMap(calculatorView);
        this.noArgFunctionshashMap = HashMapsGenerator.getNoArgFunctionHashMap(calculatorModel, matricesHashMap);
        this.argFunctionshashMap = HashMapsGenerator.getArgFunctionsHashmap(calculatorModel, matricesHashMap);
        this.functionsHashMap = HashMapsGenerator.getFunctionsHashMap(calculatorModel, matricesHashMap);
        this.inputsHashMap = HashMapsGenerator.getInputsHashMap(calculatorView);
        this.biFunctionsHashMap = HashMapsGenerator.getBiFunctionsHashMap(calculatorModel);

        addActionListeners();
    }


    private void addActionListeners() {
        addActionListenerForTwoMatrices(Actions.ADD.name());
        addActionListenerForTwoMatrices(Actions.MULTIPLY.name());
        addActionListenerForTwoMatrices(Actions.SUBTRACT.name());

        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), Matrices.MATRIX_A.name());
        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), Matrices.MATRIX_B.name());

        addPasteActionListener(Actions.PASTE.name(), Matrices.MATRIX_A.name());
        addPasteActionListener(Actions.PASTE.name(), Matrices.MATRIX_B.name());

        addBiActionListener(Actions.SCALAR_MULTIPLY.name(), Matrices.MATRIX_A.name());
        addBiActionListener(Actions.SCALAR_MULTIPLY.name(), Matrices.MATRIX_B.name());
    }

    private void addMatrixActionListeners(String matrixKey) {
        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), matrixKey);
        addPasteActionListener(Actions.PASTE.name(), matrixKey);
        addBiActionListener(Actions.SCALAR_MULTIPLY.name(), matrixKey);
    }

    private boolean isMatrixValid(String key) {
        return Validator.isArrayValid(matricesHashMap.get(key).getValues());
    }

    private void addActionListenerForTwoMatrices(String key) {
        buttonsHashMap.get(key).addActionListener(l -> {
            if (isMatrixValid(Matrices.MATRIX_A.name()) && isMatrixValid(Matrices.MATRIX_B.name())) {
                calculatorView.clearLabel();
                Integer[][] result = noArgFunctionshashMap.get(key).apply();
                createResult(result.length, result[0].length);

                calculatorView.getFrame().repaint();
                matricesHashMap.get(Matrices.RESULT_MATRIX.name()).fillFields(result);
            } else {
                calculatorView.setLabelText(StringConstants.INCORRECT_MATRIX_INPUT_MSG);
            }
        });

    }

    private void addActionListenerForOneMatrix(String keyAction, String keyMatrix) {
        buttonsHashMap.get(keyAction + "_" + keyMatrix).addActionListener(l -> {
            if (isMatrixValid(keyMatrix)) {
                calculatorView.clearLabel();
                functionsHashMap.get(keyAction).accept(matricesHashMap.get(keyMatrix));
            } else {
                calculatorView.setLabelText(StringConstants.INCORRECT_MATRIX_INPUT_MSG);
            }
        });
    }

    private void addPasteActionListener(String keyAction, String keyMatrix) {
        buttonsHashMap.get(keyAction + "_" + keyMatrix).addActionListener(l -> {
            if (isMatrixValid(keyMatrix)) {
                calculatorView.clearLabel();
                Integer[][] result = argFunctionshashMap.get(keyAction).apply(matricesHashMap.get(keyMatrix));
                if (Objects.equals(keyMatrix, Matrices.MATRIX_A.name())) {
                    calculatorView.createMatrixA(result);
                } else if (Objects.equals(keyMatrix, Matrices.MATRIX_B.name())) {
                    calculatorView.createMatrixB(result);
                }

                // BUG!!!!!
//                addMatrixActionListeners(keyMatrix);
                calculatorView.getFrame().repaint();
//                matricesHashMap.get(keyMatrix).fillFields(result);

            } else {
                calculatorView.setLabelText(StringConstants.INCORRECT_MATRIX_INPUT_MSG);
            }
        });
    }

    private void addBiActionListener(String keyAction, String keyMatrix) {
        buttonsHashMap.get(keyAction + "_" + keyMatrix).addActionListener(l -> {
            String inputValue = inputsHashMap.get(keyAction + "_" + keyMatrix).getText();

            if (isMatrixValid(keyMatrix) && Validator.isInputValid(inputValue)) {
                calculatorView.clearLabel();
                biFunctionsHashMap.get(keyAction).accept(matricesHashMap.get(keyMatrix), inputValue);

            } else {
                calculatorView.setLabelText(StringConstants.INCORRECT_MATRIX_INPUT_MSG);
            }
        });
    }

    public void createResult(int rows, int columns) {
        calculatorView.createResultMatrix(rows, columns);

        matricesHashMap.put(Matrices.RESULT_MATRIX.name(), calculatorView.getResultMatrix());

        String transposeKey = Actions.TRANSPOSE.name() + "_" + Matrices.RESULT_MATRIX.name();
        buttonsHashMap.put(transposeKey, calculatorView.getResultMatrixTranspositionButton());
        String scalarMultiplicationKey = Actions.SCALAR_MULTIPLY.name() + "_" + Matrices.RESULT_MATRIX.name();
        buttonsHashMap.put(scalarMultiplicationKey, calculatorView.getResultMatrixScalarMultiplicationButton());
        String powerKey = Actions.POWER.name() + "_" + Matrices.RESULT_MATRIX.name();
        buttonsHashMap.put(powerKey, calculatorView.getResultMatrixPowerButton());

        inputsHashMap.put(scalarMultiplicationKey, calculatorView.getResultMatrixScalarMultiplicationInput());
        inputsHashMap.put(powerKey, calculatorView.getResultMatrixPowerInput());


        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), Matrices.RESULT_MATRIX.name());
        addBiActionListener(Actions.SCALAR_MULTIPLY.name(), Matrices.RESULT_MATRIX.name());
        addBiActionListener(Actions.POWER.name(), Matrices.RESULT_MATRIX.name());

        addBiActionListener(Actions.POWER.name(), Matrices.MATRIX_A.name());
        addBiActionListener(Actions.POWER.name(), Matrices.MATRIX_B.name());
    }

    public JComboBox<Integer> getMatrixARowSelector() {
        return calculatorView.getMatrixARowSelector();
    }

    public JComboBox<Integer> getMatrixAColumnSelector() {
        return calculatorView.getMatrixAColumnSelector();
    }

    public JComboBox<Integer> getMatrixBRowSelector() {
        return calculatorView.getMatrixBRowSelector();
    }

    public JComboBox<Integer> getMatrixBColumnSelector() {
        return calculatorView.getMatrixBColumnSelector();
    }

    public CalculatorFrame getCalculatorFrame() {
        return calculatorView.getFrame();
    }
}
