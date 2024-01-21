package app.view.elements.panels;


import javax.swing.*;
import java.awt.*;

public class MatrixWithButtonsPanel extends JPanel {
    private final int WIDTH;
    private final int HEIGHT;
    private MatrixButtonsPanel buttonsPanel;
    private MatrixPanel matrix;

    public MatrixWithButtonsPanel(int rows, int columns) {
        matrix = new MatrixPanel(rows, columns);
        buttonsPanel = new MatrixButtonsPanel(matrix.getWidth());

        WIDTH = matrix.getWidth();
        HEIGHT = matrix.getHeight() + buttonsPanel.getHEIGHT() + 50;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(matrix);
        add(buttonsPanel);
    }

    public MatrixButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public MatrixPanel getMatrix() {
        return matrix;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
