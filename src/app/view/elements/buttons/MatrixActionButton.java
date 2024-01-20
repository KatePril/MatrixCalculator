package app.view.elements.buttons;

import app.view.elements.inputs.ScalarInput;

import javax.swing.*;
import java.awt.*;

public class MatrixActionButton extends JButton {

    private final int WIDTH;
    private final int HEIGHT = 40;

    public MatrixActionButton(String text, int width) {
        super(text);

        WIDTH = width - ScalarInput.getWIDTH() - 10;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
