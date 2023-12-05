package app.view.elements;

import app.entity.VisualMatrix;

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {
    private final int INPUT_WIDTH = 100;
    private final int INPUT_HEIGHT = 40;

    private VisualMatrix matrixTemplate;

    public MatrixPanel(int size) {
        int width = INPUT_WIDTH * size + (size - 1) * 10;
        int height = INPUT_HEIGHT * size + (size - 1) * 10;
        setPreferredSize(new Dimension(width, height));

        matrixTemplate = new VisualMatrix(size);
        matrixTemplate.drawMatrix(this);
    }
}
