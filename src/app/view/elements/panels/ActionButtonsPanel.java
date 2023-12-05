package app.view.elements.panels;

import app.view.elements.ActionButton;

import javax.swing.*;
import java.awt.*;

public class ActionButtonsPanel extends JPanel {
    private final int WIDTH = 60;
    private final int HEIGHT = 190;

    private ActionButton additionButton = new ActionButton("+");
    private ActionButton subtractionButton = new ActionButton("-");
    private ActionButton multiplicationButton = new ActionButton("*");


    public ActionButtonsPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(additionButton);
        add(subtractionButton);
        add(multiplicationButton);
    }
}
