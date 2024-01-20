package app.view.elements.panels;

import javax.swing.*;

public class ResultPanel extends JPanel {
    private FullMatrixPanel matrix;

    public ResultPanel(int size) {
        add(new JLabel("="));
        matrix = new FullMatrixPanel(size);
        add(matrix);
    }

    public FullMatrixPanel getMatrix() {
        return matrix;
    }
}
