package app.controller;

import app.controller.utils.KeysArrayListGenerator;
import app.controller.utils.ValuesArrayListGenerator;
import app.entity.VisualMatrix;
import app.enums.Actions;
import app.enums.Matrices;
import app.model.CalculatorModel;
import app.utils.StringConstants;
import app.utils.HashMapFiller;
import app.utils.Validator;
import app.view.CalculatorView;
import app.view.elements.CalculatorFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

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

        ArrayList<String> matricesKeys = KeysArrayListGenerator.getMatricesKeys();
        ArrayList<VisualMatrix> matrices = ValuesArrayListGenerator.getMatricesValues(calculatorView);

        this.matricesHashMap = matrixHashMapFiller.fillNewHashMap(matricesKeys, matrices);
    }

    private void fillButtonHashMap() {
        HashMapFiller<String, JButton> buttonHashMapFiller = new HashMapFiller<>();

        ArrayList<String> buttonsKeys = KeysArrayListGenerator.getButtonsKeys();
        ArrayList<JButton> buttons = ValuesArrayListGenerator.getButtonsValues(calculatorView);

        this.buttonsHashMap = buttonHashMapFiller.fillNewHashMap(buttonsKeys, buttons);
    }

    private void fillFunctionsHashMap() {
        HashMapFiller<String, Consumer<VisualMatrix>> functionsHashMapFiller = new HashMapFiller<>();

        ArrayList<String> actionsKeys = KeysArrayListGenerator.getActionsKeys();
        ArrayList<Consumer<VisualMatrix>> functions = ValuesArrayListGenerator.getFunctionsValues(calculatorModel, matricesHashMap);

        this.functionsHashMap = functionsHashMapFiller.fillNewHashMap(actionsKeys, functions);
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
