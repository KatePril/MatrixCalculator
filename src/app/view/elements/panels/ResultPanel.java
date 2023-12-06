package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private MatrixPanel matrix;

    public ResultPanel(int size) {
        JLabel label = new JLabel("=");
        add(label);
        matrix = new MatrixPanel(size);
        add(matrix);
    }

    public MatrixPanel getMatrix() {
        return matrix;
    }

    public void setMatrix(MatrixPanel matrix) {
        this.matrix = matrix;
    }
}
