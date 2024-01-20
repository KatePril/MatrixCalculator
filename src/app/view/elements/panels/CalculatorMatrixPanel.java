package app.view.elements.panels;

import javax.swing.*;

public class CalculatorMatrixPanel extends JPanel {
    FullMatrixPanel matrixA;
    FullMatrixPanel matrixB;
    ActionButtonsPanel buttonsPanel;
    ResultPanel resultMatrix;

    public CalculatorMatrixPanel(int size) {
        fillPanel(size);
    }

    private FullMatrixPanel createTranspositionPanel(int size) {
        return new FullMatrixPanel(size);
    }

    private void createButtonsPanel() {
        buttonsPanel = new ActionButtonsPanel();
        add(buttonsPanel);
    }

    private void createResultMatrix(int size) {
        resultMatrix = new ResultPanel(size);
        add(resultMatrix);
    }

    private void fillPanel(int size) {
        matrixA = createTranspositionPanel(size);
        add(matrixA);
        createButtonsPanel();
        matrixB = createTranspositionPanel(size);
        add(matrixB);

        createResultMatrix(size);
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
