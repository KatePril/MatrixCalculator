package app.view.elements.panels;

import app.enums.Sizes;

import javax.swing.*;
import java.util.HashMap;

public class CalculatorMatrixPanel extends JPanel {
    FullMatrixPanel matrixA;
    FullMatrixPanel matrixB;
    ActionButtonsPanel buttonsPanel;
    ResultPanel resultMatrix;

    public CalculatorMatrixPanel(HashMap<String, Integer> sizes) {
        fillPanel(sizes);
    }

    private FullMatrixPanel createFullMatrixPanel(int rows, int columns) {
        return new FullMatrixPanel(rows, columns);
    }

    private void createButtonsPanel() {
        buttonsPanel = new ActionButtonsPanel();
        add(buttonsPanel);
    }

    public void createResultMatrix(int rows, int columns) {
        resultMatrix = new ResultPanel(rows, columns);
        add(resultMatrix);
    }

    private void fillPanel(HashMap<String, Integer> sizes) {
        int rowsA = sizes.get(Sizes.MATRIX_A_ROWS.name());
        int columnsA = sizes.get(Sizes.MATRIX_A_COLUMNS.name());
        matrixA = createFullMatrixPanel(rowsA, columnsA);
        add(matrixA);

        createButtonsPanel();

        int rowsB = sizes.get(Sizes.MATRIX_B_ROWS.name());
        int columnsB = sizes.get(Sizes.MATRIX_B_COLUMNS.name());
        matrixB = createFullMatrixPanel(rowsB, columnsB);
        add(matrixB);

//        createResultMatrix(rowsA, columnsB);
    }

    public FullMatrixPanel getMatrixA() {
        return matrixA;
    }

    public FullMatrixPanel getMatrixB() {
        return matrixB;
    }

    public ActionButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public ResultPanel getResultMatrix() {
        return resultMatrix;
    }
}
