package app.view.elements.panels;

import javax.swing.*;

public class CalculatorMatrixPanel extends JPanel {
    TranspositionPanel matrixA;
    TranspositionPanel matrixB;
    ActionButtonsPanel buttonsPanel;
    ResultPanel resultMatrix;

    public CalculatorMatrixPanel(int size) {
        fillPanel(size);
    }

    private TranspositionPanel createTranspositionPanel(int size) {
        return new TranspositionPanel(size);
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

    public TranspositionPanel getMatrixA() {
        return matrixA;
    }

    public TranspositionPanel getMatrixB() {
        return matrixB;
    }

    public ActionButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public ResultPanel getResultMatrix() {
        return resultMatrix;
    }
}
