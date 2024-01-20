package app.view;

import app.entity.VisualMatrix;
import app.view.elements.CalculatorFrame;

import javax.swing.*;

public class CalculatorView {
    CalculatorFrame frame;

    public CalculatorView(int size) {
        frame = new CalculatorFrame("Calculator", size);
    }

    public void clearLabel() {
        frame.getPanel().clearLabel();
    }

    public void setLabelText(String text) {
        frame.getPanel().setLabelText(text);
    }

    public CalculatorFrame getFrame() {
        return frame;
    }

    public JComboBox<Integer> getSizeSelector() {
        return frame.getPanel().getSizeSelector();
    }

    public VisualMatrix getMatrixA() {
        return frame.getPanel().getPanel().getMatrixA().getMatrix().getMatrix();
    }

    public VisualMatrix getMatrixB() {
        return frame.getPanel().getPanel().getMatrixB().getMatrix().getMatrix();
    }

    public VisualMatrix getResultMatrix() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getMatrix().getMatrix();
    }

    public JButton getAdditionButton() {
        return frame.getPanel().getPanel().getButtonsPanel().getAdditionButton();
    }

    public JButton getSubtractionButton() {
        return frame.getPanel().getPanel().getButtonsPanel().getSubtractionButton();
    }

    public JButton getMultiplicationButton() {
        return frame.getPanel().getPanel().getButtonsPanel().getMultiplicationButton();
    }

    public JButton getMatrixATranspositionButton() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getTranspositionButton();
    }

    public JButton getMatrixAScalarMultiplicationButton() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getScalarMultiplicationButton();
    }

    public JButton getMatrixAPowerButton() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getPowerButton();
    }

    public JTextField getMatrixAScalarMultiplicationInput() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getScalarInput();
    }

    public JTextField getMatrixAPowerInput() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getPowerInput();
    }

    public JButton getMatrixBTranspositionButton() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getTranspositionButton();
    }

    public JButton getMatrixBScalarMultiplicationButton() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getScalarMultiplicationButton();
    }

    public JButton getMatrixBPowerButton() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getPowerButton();
    }

    public JTextField getMatrixBScalarMultiplicationInput() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getScalarInput();
    }

    public JTextField getMatrixBPowerInput() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getPowerInput();
    }

    public JButton getResultMatrixTranspositionButton() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getPanel().getTranspositionButton();
    }

    public JButton getResultMatrixScalarMultiplicationButton() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getPanel().getScalarMultiplicationButton();
    }

    public JButton getResultMatrixPowerButton() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getPanel().getPowerButton();
    }

    public JTextField getResultMatrixScalarMultiplicationInput() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getPanel().getScalarInput();
    }

    public JTextField getResultMatrixPowerInput() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getPanel().getPowerInput();
    }

    public JButton getPasteMatrixAButton() {
        return frame.getPanel().getPastePanel().getPasteMatrixAButton();
    }

    public JButton getPasteMatrixBButton() {
        return frame.getPanel().getPastePanel().getPasteMatrixBButton();
    }
}
