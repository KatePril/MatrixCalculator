package app.view.elements;

import javax.swing.*;
import java.awt.*;

public class ActionButton extends JButton {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public ActionButton(String text) {
        super(text);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}
