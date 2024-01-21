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
        repaint();
    }

    public void createMatrixA(int rows, int columns) {
        if (matrixA != null) {
            matrixA.removeAll();
        }

        matrixA = createFullMatrixPanel(rows, columns);
        add(matrixA);
    }
    public void createMatrixB(int rows, int columns) {
        if (matrixB != null) {
            matrixB.removeAll();
        }

        matrixB = createFullMatrixPanel(rows, columns);
        add(matrixB);
    }


    private void fillPanel(HashMap<String, Integer> sizes) {
        int rowsA = sizes.get(Sizes.MATRIX_A_ROWS.name());
        int columnsA = sizes.get(Sizes.MATRIX_A_COLUMNS.name());
        createMatrixA(rowsA, columnsA);

        createButtonsPanel();

        int rowsB = sizes.get(Sizes.MATRIX_B_ROWS.name());
        int columnsB = sizes.get(Sizes.MATRIX_B_COLUMNS.name());
        createMatrixB(rowsB, columnsB);
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
