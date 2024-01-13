package app.view.elements;

import javax.swing.*;
import java.awt.*;

public class MatrixInput extends JTextField {
    private static final int HEIGHT = 40;
    private static final int WIDTH = 100;

    public MatrixInput(int columns) {
        super(columns);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}
