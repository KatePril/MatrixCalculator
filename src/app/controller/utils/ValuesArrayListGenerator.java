package app.controller.utils;

import app.entity.VisualMatrix;
import app.enums.Matrices;
import app.model.CalculatorModel;
import app.model.MatrixPowerer;
import app.model.MatrixScalarMultiplier;
import app.utils.Converter;
import app.utils.StringConstants;
import app.utils.Validator;
import app.view.CalculatorView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class ValuesArrayListGenerator {

    public static ArrayList<VisualMatrix> getMatricesValues(CalculatorView calculatorView) {
        ArrayList<VisualMatrix> matrices = new ArrayList<>();

        matrices.add(calculatorView.getMatrixA());
        matrices.add(calculatorView.getMatrixB());
        matrices.add(calculatorView.getResultMatrix());

        return matrices;
    }

    public static ArrayList<JButton> getButtonsValues(CalculatorView view) {
        ArrayList<JButton> buttons = new ArrayList<>();

        buttons.add(view.getAdditionButton());
        buttons.add(view.getMultiplicationButton());
        buttons.add(view.getSubtractionButton());

        buttons.add(view.getMatrixATranspositionButton());
        buttons.add(view.getMatrixBTranspositionButton());
        buttons.add(view.getResultMatrixTranspositionButton());

        buttons.add(view.getMatrixAScalarMultiplicationButton());
        buttons.add(view.getMatrixBScalarMultiplicationButton());
        buttons.add(view.getResultMatrixScalarMultiplicationButton());

        buttons.add(view.getMatrixAPowerButton());
        buttons.add(view.getMatrixBPowerButton());
        buttons.add(view.getResultMatrixPowerButton());

        buttons.add(view.getPasteMatrixAButton());
        buttons.add(view.getPasteMatrixBButton());

        return buttons;
    }

    public static ArrayList<JTextField> getInputsValues(CalculatorView view) {
        ArrayList<JTextField> inputs = new ArrayList<>();

        inputs.add(view.getMatrixAScalarMultiplicationInput());
        inputs.add(view.getMatrixBScalarMultiplicationInput());
        inputs.add(view.getResultMatrixScalarMultiplicationInput());

        inputs.add(view.getMatrixAPowerInput());
        inputs.add(view.getMatrixBPowerInput());
        inputs.add(view.getResultMatrixPowerInput());

        return inputs;
    }

    public static ArrayList<Consumer<VisualMatrix>> getFunctionsValues(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        ArrayList<Consumer<VisualMatrix>> functions = new ArrayList<>();

        functions.add((result) -> {
                String[][] matrixAValues = matrices.get(Matrices.MATRIX_A.name()).getValues();
                Integer[][] matrixAIntValues = Converter.convertStringArrayToIntArray(matrixAValues);

                String[][] matrixBValues = matrices.get(Matrices.MATRIX_B.name()).getValues();
                Integer[][] matrixBIntValues = Converter.convertStringArrayToIntArray(matrixBValues);

                Integer[][] matrix = model.addMatrices(matrixAIntValues, matrixBIntValues);
                result.fillFields(matrix);
            }
        );

        functions.add((result) -> {
                String[][] matrixAValues = matrices.get(Matrices.MATRIX_A.name()).getValues();
                Integer[][] matrixAIntValues = Converter.convertStringArrayToIntArray(matrixAValues);

                String[][] matrixBValues = matrices.get(Matrices.MATRIX_B.name()).getValues();
                Integer[][] matrixBIntValues = Converter.convertStringArrayToIntArray(matrixBValues);

                Integer[][] matrix = model.multiplyMatrices(matrixAIntValues, matrixBIntValues);
                result.fillFields(matrix);
            }
        );

        functions.add((result) -> {
                String[][] matrixAValues = matrices.get(Matrices.MATRIX_A.name()).getValues();
                Integer[][] matrixAIntValues = Converter.convertStringArrayToIntArray(matrixAValues);

                String[][] matrixBValues = matrices.get(Matrices.MATRIX_B.name()).getValues();
                Integer[][] matrixBIntValues = Converter.convertStringArrayToIntArray(matrixBValues);

                Integer[][] matrix = model.subtractMatrices(matrixAIntValues, matrixBIntValues);
                result.fillFields(matrix);
            }
        );

        functions.add((matrix) -> {
                Integer[][] matrixValues = Converter.convertStringArrayToIntArray(matrix.getValues());
                matrix.fillFields(model.transposeMatrix(matrixValues));
            }
        );

        functions.add((matrix) -> {
                String[][] matrixValues = matrices.get(Matrices.RESULT_MATRIX.name()).getValues();
                Integer[][] matrixIntValues = Converter.convertStringArrayToIntArray(matrixValues);

                matrix.fillFields(matrixIntValues);
            }
        );

        return functions;
    }

    public static ArrayList<BiConsumer<VisualMatrix, String>> getBiFunctionsValues(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        ArrayList<BiConsumer<VisualMatrix, String>> functions = new ArrayList<>();

        functions.add((matrix, input) -> {
                Integer[][] matrixValues = Converter.convertStringArrayToIntArray(matrix.getValues());
                Integer scalar = Integer.parseInt(input);

                Integer[][] newMatrix = model.scalarMultiplyMatrices(matrixValues, scalar);

                matrix.fillFields(newMatrix);
            }
        );

        functions.add((matrix, input) -> {
                Integer[][] matrixValues = Converter.convertStringArrayToIntArray(matrix.getValues());
                Integer scalar = Integer.parseInt(input);

                Integer[][] newMatrix = model.powerMatrices(matrixValues, scalar);

                matrix.fillFields(newMatrix);
            }
        );

        return functions;
    }

    public static ArrayList<Predicate<String>> getValidationValues() {
        ArrayList<Predicate<String>> validationArray = new ArrayList<>();

        validationArray.add((input) -> Validator.isScalarValid(input));
        validationArray.add((input) -> Validator.isPowerValid(input));

        return validationArray;
    }

    public static ArrayList<String> getValidationMsgValues() {
        ArrayList<String> msgArray = new ArrayList<>();

        msgArray.add(StringConstants.INCORRECT_SCALAR_MSG);
        msgArray.add(StringConstants.INCORRECT_POWER_MSG);

        return msgArray;
    }
}
