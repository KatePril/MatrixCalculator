package app.view.elements;

import javax.swing.*;
import java.awt.*;

public class MatrixInput extends JTextField {
    private final int HEIGHT = 40;
    private final int WIDTH = 100;

    public MatrixInput(int columns, int i, int j) {
        super(columns);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }
}
