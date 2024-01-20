package app.view.elements.panels;

import app.view.elements.buttons.MatrixActionButton;
import app.view.elements.buttons.TranspositionButton;
import app.view.elements.inputs.ScalarInput;

import javax.swing.*;
import java.awt.*;

public class MatrixButtonsPanel extends JPanel {

    private final int WIDTH;
    private final int HEIGHT;

    private TranspositionButton transpositionButton;
    private MatrixActionButton scalarMultiplicationButton;
    private MatrixActionButton powerButton;
    private final ScalarInput scalarInput = new ScalarInput();
    private final ScalarInput powerInput = new ScalarInput();


    public MatrixButtonsPanel(int width) {
        fillWithButtons(width);

        WIDTH = width;
        int height = transpositionButton.getHEIGHT() + scalarMultiplicationButton.getHEIGHT() + powerButton.getHEIGHT();
        HEIGHT = height + 50;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    private void fillWithButtons(int width) {
        transpositionButton = new TranspositionButton(width);
        add(transpositionButton);

        scalarMultiplicationButton = new MatrixActionButton("Multiply", width);
        add(scalarMultiplicationButton);
        add(scalarInput);

        powerButton = new MatrixActionButton("Power", width);
        add(powerButton);
        add(powerInput);
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public TranspositionButton getTranspositionButton() {
        return transpositionButton;
    }

    public MatrixActionButton getScalarMultiplicationButton() {
        return scalarMultiplicationButton;
    }

    public MatrixActionButton getPowerButton() {
        return powerButton;
    }

    public ScalarInput getScalarInput() {
        return scalarInput;
    }

    public ScalarInput getPowerInput() {
        return powerInput;
    }
}
