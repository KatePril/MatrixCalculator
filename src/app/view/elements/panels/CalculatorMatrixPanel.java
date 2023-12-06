package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class CalculatorMatrixPanel extends JPanel {

    TranspositionPanel matrixA;
    TranspositionPanel matrixB;
    ActionButtonsPanel buttonsPanel;
    ResultPanel resultMatrix;

    public CalculatorMatrixPanel() {
        fillWithMatrix(2);
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



//    @Override
//    public void paint(Graphics graphics) {
//        super();

//    }

    public void changeSize(int size) {
        removeAll();
        fillWithMatrix(4);
        repaint();
    }
}
