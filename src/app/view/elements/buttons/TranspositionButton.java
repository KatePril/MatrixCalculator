package app.view.elements.buttons;

import javax.swing.*;
import java.awt.*;

public class TranspositionButton extends JButton {

    private final int WIDTH;
    private final int HEIGHT = 40;

    public TranspositionButton(int width) {
        setText("Transpose");
        WIDTH = width - 10;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
