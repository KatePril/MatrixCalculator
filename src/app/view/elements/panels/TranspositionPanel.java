package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class TranspositionPanel extends JPanel {
    private final JButton button = new JButton("Transpose");
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

    public MatrixPanel getMatrix() {
        return matrix;
    }
}
