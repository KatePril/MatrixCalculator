package app.view.elements;

import javax.swing.*;
import java.awt.*;

public class ActionButton extends JButton {
    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    public ActionButton(String text) {
        super(text);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
