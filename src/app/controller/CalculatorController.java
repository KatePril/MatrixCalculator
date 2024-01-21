package app.controller;

import app.controller.utils.HashMapsGenerator;
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
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

    private final HashMap<String, VisualMatrix> matricesHashMap;
    private final HashMap<String, JButton> buttonsHashMap;
    private final HashMap<String, Consumer<VisualMatrix>> functionsHashMap;
    private final HashMap<String, JTextField> inputsHashMap;
    private final HashMap<String, BiConsumer<VisualMatrix, String>> biFunctionsHashMap;


    public CalculatorController(HashMap<String, Integer> sizes) {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView(sizes);

        this.matricesHashMap = HashMapsGenerator.getMatricesHashMap(calculatorView);
        this.buttonsHashMap = HashMapsGenerator.getButtonsHashMap(calculatorView);
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
        addActionListenerForOneMatrix(Actions.TRANSPOSE.name(), Matrices.RESULT_MATRIX.name());

        addActionListenerForOneMatrix(Actions.PASTE.name(), Matrices.MATRIX_A.name());
        addActionListenerForOneMatrix(Actions.PASTE.name(), Matrices.MATRIX_B.name());

        addBiActionListener(Actions.SCALAR_MULTIPLY.name(), Matrices.MATRIX_A.name());
        addBiActionListener(Actions.SCALAR_MULTIPLY.name(), Matrices.MATRIX_B.name());
        addBiActionListener(Actions.SCALAR_MULTIPLY.name(), Matrices.RESULT_MATRIX.name());

        addBiActionListener(Actions.POWER.name(), Matrices.MATRIX_A.name());
        addBiActionListener(Actions.POWER.name(), Matrices.MATRIX_B.name());
        addBiActionListener(Actions.POWER.name(), Matrices.RESULT_MATRIX.name());
    }

    private boolean isMatrixValid(String key) {
        return Validator.isArrayValid(matricesHashMap.get(key).getValues());
    }

    private void addActionListenerForTwoMatrices(String key) {
        buttonsHashMap.get(key).addActionListener(l -> {
            if (isMatrixValid(Matrices.MATRIX_A.name()) && isMatrixValid(Matrices.MATRIX_B.name())) {

                calculatorView.clearLabel();
                functionsHashMap.get(key).accept(matricesHashMap.get(Matrices.RESULT_MATRIX.name()));

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


//    public JComboBox<Integer> getSizeSelector() {
//        return calculatorView.getSizeSelector();
//    }

    public CalculatorFrame getCalculatorFrame() {
        return calculatorView.getFrame();
    }
}
