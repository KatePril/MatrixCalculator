package app.view.elements.panels;

import app.entity.VisualMatrix;
import app.view.elements.MatrixInput;

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {
    private static final int INPUT_WIDTH = MatrixInput.getWIDTH();
    private static final int INPUT_HEIGHT = MatrixInput.getHEIGHT();

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;

    private VisualMatrix matrix;

    public MatrixPanel(int size) {
        PANEL_WIDTH = INPUT_WIDTH * size + (size - 1) * 10;
        PANEL_HEIGHT = INPUT_HEIGHT * size + (size - 1) * 10;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        matrix = new VisualMatrix(size);
        matrix.drawMatrix(this);
    }

    public VisualMatrix getMatrix() {
        return matrix;
    }

    @Override
    public int getWidth() {
        return PANEL_WIDTH;
    }

    @Override
    public int getHeight() {
        return PANEL_HEIGHT;
    }
}
