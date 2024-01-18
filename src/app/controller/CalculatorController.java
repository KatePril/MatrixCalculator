package app.controller;

import app.controller.utils.HashMapsGenerator;
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

    private final HashMap<String, VisualMatrix> matricesHashMap;
    private final HashMap<String, JButton> buttonsHashMap;
    private final HashMap<String, Consumer<VisualMatrix>> functionsHashMap;

    public CalculatorController(int size) {
        this.calculatorModel = new CalculatorModel();
        this.calculatorView = new CalculatorView(size);

        this.matricesHashMap = HashMapsGenerator.getMatricesHashMap(calculatorView);
        this.buttonsHashMap = HashMapsGenerator.getButtonsHashMap(calculatorView);
        this.functionsHashMap = HashMapsGenerator.getFunctionsHashMap(calculatorModel, matricesHashMap);

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
                calculatorView.setLabelText(StringConstants.INCORRECT_DATA_MSG);
            }
        });

    }


    private void addActionListenerForOneMatrix(String keyAction, String keyMatrix) {
        buttonsHashMap.get(keyAction + "_" + keyMatrix).addActionListener(l -> {
            if (isMatrixValid(keyMatrix)) {
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
