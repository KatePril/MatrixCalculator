package app.view.elements.panels;

import javax.swing.*;

public class ResultPanel extends JPanel {
    private MatrixWithButtonsPanel matrix;

    public ResultPanel(int rows, int columns) {
        add(new JLabel("="));
        matrix = new MatrixWithButtonsPanel(rows, columns);

        add(matrix);
    }

    public MatrixWithButtonsPanel getMatrix() {
        return matrix;
    }
}
