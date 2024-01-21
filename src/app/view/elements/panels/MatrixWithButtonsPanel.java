package app.view.elements.panels;


import javax.swing.*;
import java.awt.*;

public class MatrixWithButtonsPanel extends JPanel {
    private MatrixButtonsPanel buttonsPanel;
    private MatrixPanel matrix;

    public MatrixWithButtonsPanel(int rows, int columns) {
        matrix = new MatrixPanel(rows, columns);
        buttonsPanel = new MatrixButtonsPanel(matrix.getWidth());

        setPreferredSize(new Dimension(matrix.getWidth(), matrix.getHeight() + buttonsPanel.getHEIGHT() + 50));
        add(matrix);
        add(buttonsPanel);
    }

    public MatrixButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public MatrixPanel getMatrix() {
        return matrix;
    }
}
