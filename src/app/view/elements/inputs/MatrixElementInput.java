package app.view.elements.inputs;

import javax.swing.*;
import java.awt.*;

public class MatrixElementInput extends JTextField {
    private static final int HEIGHT = 40;
    private static final int WIDTH = 60;

    public MatrixElementInput() {
        super(0);
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
