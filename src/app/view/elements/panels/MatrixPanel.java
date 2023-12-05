package app.view.elements.panels;

import app.entity.VisualMatrix;

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {
    private final int INPUT_WIDTH = 100;
    private final int INPUT_HEIGHT = 40;

    private int width;
    private int height;

    private VisualMatrix matrixTemplate;

    public MatrixPanel(int size) {
        width = INPUT_WIDTH * size + (size - 1) * 10;
        height = INPUT_HEIGHT * size + (size - 1) * 10;
        setPreferredSize(new Dimension(width, height));

        matrixTemplate = new VisualMatrix(size);
        matrixTemplate.drawMatrix(this);
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
