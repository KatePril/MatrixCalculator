package app.view.elements.panels;


import javax.swing.*;
import java.awt.*;

public class FullMatrixPanel extends JPanel {
    private MatrixButtonsPanel panel;
    private MatrixPanel matrix;

    public FullMatrixPanel(int size) {
        matrix = new MatrixPanel(size);
        panel = new MatrixButtonsPanel(matrix.getWidth());

        setPreferredSize(new Dimension(matrix.getWidth(), matrix.getHeight() + panel.getHEIGHT() + 50));

        add(matrix);
        add(panel);
    }

    public MatrixButtonsPanel getPanel() {
        return panel;
    }

    public MatrixPanel getMatrix() {
        return matrix;
    }
}
