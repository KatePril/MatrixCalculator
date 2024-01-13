package app.view.elements.panels;

import app.view.elements.ActionButton;

import javax.swing.*;
import java.awt.*;

public class ActionButtonsPanel extends JPanel {
    private static final int HORIZONTAL_SPACE = 10;
    private static final int VERTICAL_SPACE = 40;
    private static final int BUTTONS_NUMBER = 3;
    private final int WIDTH = ActionButton.getWIDTH() + HORIZONTAL_SPACE;
    private final int HEIGHT = ActionButton.getHEIGHT() * BUTTONS_NUMBER + VERTICAL_SPACE;

    private final ActionButton additionButton = new ActionButton("+");
    private final ActionButton subtractionButton = new ActionButton("-");
    private final ActionButton multiplicationButton = new ActionButton("*");


    public ActionButtonsPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(additionButton);
        add(subtractionButton);
        add(multiplicationButton);
    }

    public ActionButton getAdditionButton() {
        return additionButton;
    }

    public ActionButton getSubtractionButton() {
        return subtractionButton;
    }

    public ActionButton getMultiplicationButton() {
        return multiplicationButton;
    }
}
