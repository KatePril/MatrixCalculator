package app.view.elements.panels;

import javax.swing.*;

public class CalculatorMatrixPanel extends JPanel {

    TranspositionPanel matrixA;
    TranspositionPanel matrixB;
    ActionButtonsPanel buttonsPanel;
    ResultPanel resultMatrix;

    public CalculatorMatrixPanel(int size) {
        fillWithMatrix(size);
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

    private void fillWithMatrix(int size) {
        matrixA = createTranspositionPanel(size);
        add(matrixA);
        createButtonsPanel();
        matrixB = createTranspositionPanel(size);
        add(matrixB);

        createResultMatrix(size);
    }

//    public void changeSize(int size) {
//        removeAll();
//        fillWithMatrix(size);
//        repaint();
//    }

    public TranspositionPanel getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(TranspositionPanel matrixA) {
        this.matrixA = matrixA;
    }

    public TranspositionPanel getMatrixB() {
        return matrixB;
    }

    public void setMatrixB(TranspositionPanel matrixB) {
        this.matrixB = matrixB;
    }

    public ActionButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void setButtonsPanel(ActionButtonsPanel buttonsPanel) {
        this.buttonsPanel = buttonsPanel;
    }

    public ResultPanel getResultMatrix() {
        return resultMatrix;
    }

    public void setResultMatrix(ResultPanel resultMatrix) {
        this.resultMatrix = resultMatrix;
    }
}
