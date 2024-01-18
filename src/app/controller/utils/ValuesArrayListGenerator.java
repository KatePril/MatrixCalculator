package app.controller.utils;

import app.entity.VisualMatrix;
import app.enums.Matrices;
import app.model.CalculatorModel;
import app.utils.Converter;
import app.view.CalculatorView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
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
        buttons.add(view.getPasteMatrixAButton());
        buttons.add(view.getPasteMatrixBButton());

        return buttons;
    }

    public static ArrayList<Consumer<VisualMatrix>> getFunctionsValues(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        ArrayList<Consumer<VisualMatrix>> functions = new ArrayList<>();

        functions.add((result) -> {
                    int[][] matrix = model.addMatrices(
                            Converter.convertStringArrayToIntArray(matrices.get(Matrices.MATRIX_A.name()).getValues()),
                            Converter.convertStringArrayToIntArray(matrices.get(Matrices.MATRIX_B.name()).getValues())
                    );
                    result.fillFields(matrix);
                }
        );

        functions.add((result) -> {
                    int[][] matrix = model.multiplyMatrices(
                            Converter.convertStringArrayToIntArray(matrices.get(Matrices.MATRIX_A.name()).getValues()),
                            Converter.convertStringArrayToIntArray(matrices.get(Matrices.MATRIX_B.name()).getValues())
                    );
                    result.fillFields(matrix);
                }
        );

        functions.add((result) -> {
                    int[][] matrix = model.subtractMatrices(
                            Converter.convertStringArrayToIntArray(matrices.get(Matrices.MATRIX_A.name()).getValues()),
                            Converter.convertStringArrayToIntArray(matrices.get(Matrices.MATRIX_B.name()).getValues())
                    );
                    result.fillFields(matrix);
                }
        );

        functions.add((matrix) -> matrix.fillFields(model.transposeMatrix(
                Converter.convertStringArrayToIntArray(matrix.getValues())))
        );

        functions.add((matrix) -> matrix.fillFields(
                Converter.convertStringArrayToIntArray(matrices.get(Matrices.RESULT_MATRIX.name()).getValues()))
        );

        return functions;
    }
}
