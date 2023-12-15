package app.view.elements.panels;

import app.entity.VisualMatrix;

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {
    private final int INPUT_WIDTH = 100;
    private final int INPUT_HEIGHT = 40;

    private int width;
    private int height;

    private VisualMatrix matrix;

    public MatrixPanel(int size) {
        width = INPUT_WIDTH * size + (size - 1) * 10;
        height = INPUT_HEIGHT * size + (size - 1) * 10;
        setPreferredSize(new Dimension(width, height));

        matrix = new VisualMatrix(size);
        matrix.drawMatrix(this);
    }

    public VisualMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(VisualMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
