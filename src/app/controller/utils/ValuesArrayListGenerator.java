package app.controller.utils;

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

    public static ArrayList<BiConsumer<VisualMatrix, Integer>> getBiFunctionsValues(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        ArrayList<BiConsumer<VisualMatrix, Integer>> functions = new ArrayList<>();

        functions.add((matrix, scalar) -> {
                Integer[][] matrixValues = Converter.convertStringArrayToIntArray(matrix.getValues());
                Integer[][] newMatrix = MatrixScalarMultiplier.multiplyMatrix(matrixValues, scalar);

                matrix.fillFields(newMatrix);
            }
        );

        functions.add((matrix, scalar) -> {
                Integer[][] matrixValues = Converter.convertStringArrayToIntArray(matrix.getValues());
                Integer[][] newMatrix = MatrixPowerer.powerMatrix(matrixValues, scalar);

                matrix.fillFields(newMatrix);
            }
        );

        return functions;
    }
}
