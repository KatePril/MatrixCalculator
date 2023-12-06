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

    public ActionButton getAdditionButton() {
        return additionButton;
    }

    public void setAdditionButton(ActionButton additionButton) {
        this.additionButton = additionButton;
    }

    public ActionButton getSubtractionButton() {
        return subtractionButton;
    }

    public void setSubtractionButton(ActionButton subtractionButton) {
        this.subtractionButton = subtractionButton;
    }

    public ActionButton getMultiplicationButton() {
        return multiplicationButton;
    }

    public void setMultiplicationButton(ActionButton multiplicationButton) {
        this.multiplicationButton = multiplicationButton;
    }
}
