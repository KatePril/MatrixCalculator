package app.view.elements.panels;

import javax.swing.*;

public class ResultPanel extends JPanel {
    private FullMatrixPanel matrix;

    public ResultPanel(int rows, int columns) {
        add(new JLabel("="));
        matrix = new FullMatrixPanel(rows, columns);
        add(matrix);
    }

    public FullMatrixPanel getMatrix() {
        return matrix;
    }
}
