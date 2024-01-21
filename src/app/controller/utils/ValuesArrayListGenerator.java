package app.controller.utils;

import app.controller.CalculatorController;
import app.entity.VisualMatrix;
import app.enums.Matrices;
import app.model.CalculatorModel;
import app.model.MatrixPowerer;
import app.model.MatrixScalarMultiplier;
import app.utils.Converter;
import app.view.CalculatorView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public final class ValuesArrayListGenerator {

    public static ArrayList<VisualMatrix> getMatricesValues(CalculatorView calculatorView) {
        ArrayList<VisualMatrix> matrices = new ArrayList<>();

        matrices.add(calculatorView.getMatrixA());
        matrices.add(calculatorView.getMatrixB());

        return matrices;
    }

    public static ArrayList<JButton> getButtonsValues(CalculatorView view) {
        ArrayList<JButton> buttons = new ArrayList<>();

        buttons.add(view.getAdditionButton());
        buttons.add(view.getMultiplicationButton());
        buttons.add(view.getSubtractionButton());

        buttons.add(view.getMatrixATranspositionButton());
        buttons.add(view.getMatrixBTranspositionButton());

        buttons.add(view.getMatrixAScalarMultiplicationButton());
        buttons.add(view.getMatrixBScalarMultiplicationButton());

        buttons.add(view.getMatrixAPowerButton());
        buttons.add(view.getMatrixBPowerButton());

        buttons.add(view.getPasteMatrixAButton());
        buttons.add(view.getPasteMatrixBButton());

        return buttons;
    }

    public static ArrayList<JTextField> getInputsValues(CalculatorView view) {
        ArrayList<JTextField> inputs = new ArrayList<>();

        inputs.add(view.getMatrixAScalarMultiplicationInput());
        inputs.add(view.getMatrixBScalarMultiplicationInput());

        inputs.add(view.getMatrixAPowerInput());
        inputs.add(view.getMatrixBPowerInput());

        return inputs;
    }

    public static ArrayList<NoArgumentFunction<Integer[][]>> getNoArgFunction(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        ArrayList<NoArgumentFunction<Integer[][]>> functions = new ArrayList<>();

        functions.add(() -> {
                    String[][] matrixAValues = matrices.get(Matrices.MATRIX_A.name()).getValues();
                    Integer[][] matrixAIntValues = Converter.convertStringArrayToIntArray(matrixAValues);

                    String[][] matrixBValues = matrices.get(Matrices.MATRIX_B.name()).getValues();
                    Integer[][] matrixBIntValues = Converter.convertStringArrayToIntArray(matrixBValues);

                    Integer[][] matrix = model.addMatrices(matrixAIntValues, matrixBIntValues);

                    return matrix;
                }
        );

        functions.add(() -> {
                    String[][] matrixAValues = matrices.get(Matrices.MATRIX_A.name()).getValues();
                    Integer[][] matrixAIntValues = Converter.convertStringArrayToIntArray(matrixAValues);

                    String[][] matrixBValues = matrices.get(Matrices.MATRIX_B.name()).getValues();
                    Integer[][] matrixBIntValues = Converter.convertStringArrayToIntArray(matrixBValues);

                    Integer[][] matrix = model.multiplyMatrices(matrixAIntValues, matrixBIntValues);

                    return matrix;
                }
        );

        functions.add(() -> {
                    String[][] matrixAValues = matrices.get(Matrices.MATRIX_A.name()).getValues();
                    Integer[][] matrixAIntValues = Converter.convertStringArrayToIntArray(matrixAValues);

                    String[][] matrixBValues = matrices.get(Matrices.MATRIX_B.name()).getValues();
                    Integer[][] matrixBIntValues = Converter.convertStringArrayToIntArray(matrixBValues);

                    Integer[][] matrix = model.subtractMatrices(matrixAIntValues, matrixBIntValues);

                    return matrix;
                }
        );

        return functions;
    }

    public static ArrayList<Consumer<VisualMatrix>> getFunctionsValues(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        ArrayList<Consumer<VisualMatrix>> functions = new ArrayList<>();

        functions.add((matrix) -> {
                Integer[][] matrixValues = Converter.convertStringArrayToIntArray(matrix.getValues());
                matrix.fillFields(model.transposeMatrix(matrixValues));
            }
        );

        return functions;
    }

    public static ArrayList<Function<VisualMatrix,  Integer[][]>> getArgFunctionValues(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        ArrayList<Function<VisualMatrix,  Integer[][]>> functions = new ArrayList<>();

        functions.add((matrix) -> {
                    String[][] matrixValues = matrices.get(Matrices.RESULT_MATRIX.name()).getValues();
                    Integer[][] matrixIntValues = Converter.convertStringArrayToIntArray(matrixValues);
                    return matrixIntValues;
                }
        );

        return functions;
    }

    public static ArrayList<BiConsumer<VisualMatrix, String>> getBiFunctionsValues(CalculatorModel model) {
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

    public static ArrayList<JComboBox<Integer>> getSizeSelectorsValues(CalculatorController controller) {
        ArrayList<JComboBox<Integer>> selectorsValues = new ArrayList<>();

        selectorsValues.add(controller.getMatrixARowSelector());
        selectorsValues.add(controller.getMatrixAColumnSelector());
        selectorsValues.add(controller.getMatrixBRowSelector());
        selectorsValues.add(controller.getMatrixBColumnSelector());

        return selectorsValues;
    }
}
