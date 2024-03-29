package app.view.elements.panels;

import app.entity.VisualMatrix;
import app.view.elements.inputs.MatrixElementInput;

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {
    private static final int SPACE_SIZE = 10;

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;

    private VisualMatrix matrix;

    public MatrixPanel(int size) {
        int numberOfSpaces = size - 1;
        PANEL_WIDTH = MatrixElementInput.getWIDTH() * size + numberOfSpaces * SPACE_SIZE;
        PANEL_HEIGHT = MatrixElementInput.getHEIGHT() * size + numberOfSpaces * SPACE_SIZE;
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
