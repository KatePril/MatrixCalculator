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

    public MatrixPanel(int rows, int columns) {
        int numberOfRowSpaces = rows - 1;
        int numberOfColumnSpaces = columns - 1;
        PANEL_WIDTH = MatrixElementInput.getWIDTH() * columns + numberOfColumnSpaces * SPACE_SIZE;
        PANEL_HEIGHT = MatrixElementInput.getHEIGHT() * rows + numberOfRowSpaces * SPACE_SIZE;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        matrix = new VisualMatrix(rows, columns);
        matrix.drawMatrix(this);
    }

    public VisualMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][] values) {
        if (matrix != null) {
            matrix.deleteMatrix();
        }
        this.matrix = new VisualMatrix(values);
        matrix.drawMatrix(this);
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
