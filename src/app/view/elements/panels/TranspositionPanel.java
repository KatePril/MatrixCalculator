package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class TranspositionPanel extends JPanel {
    private JButton button = new JButton("Transpose");
    private MatrixPanel matrix;

    public TranspositionPanel(int size) {
        matrix = new MatrixPanel(size);

        button.setPreferredSize(new Dimension(matrix.getWidth(), 40));
        setPreferredSize(new Dimension(matrix.getWidth(), matrix.getHeight()+60));

        add(matrix);
        add(button);
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public MatrixPanel getMatrix() {
        return matrix;
    }

    public void setMatrix(MatrixPanel matrix) {
        this.matrix = matrix;
    }
}
