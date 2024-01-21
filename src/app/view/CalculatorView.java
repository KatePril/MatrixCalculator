package app.view;

import app.entity.VisualMatrix;
import app.view.elements.CalculatorFrame;

import javax.swing.*;
import java.util.HashMap;

public class CalculatorView {
    CalculatorFrame frame;

    public CalculatorView(HashMap<String, Integer> sizes) {
        frame = new CalculatorFrame("Calculator", sizes);
    }

    public void clearLabel() {
        frame.getPanel().clearLabel();
    }

    public void setLabelText(String text) {
        frame.getPanel().setLabelText(text);
    }

    public void createResultMatrix(int rows, int columns) {
        frame.getPanel().createResultMatrix(rows, columns);
    }

    public CalculatorFrame getFrame() {
        return frame;
    }

    public VisualMatrix getMatrixA() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getMatrix().getMatrix();
    }

    public VisualMatrix getMatrixB() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getMatrix().getMatrix();
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
        return frame.getPanel().getPanel().getMatrixA().getPanel().getButtonsPanel().getTranspositionButton();
    }

    public JButton getMatrixAScalarMultiplicationButton() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getButtonsPanel().getScalarMultiplicationButton();
    }

    public JButton getMatrixAPowerButton() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getButtonsPanel().getPowerButton();
    }

    public JTextField getMatrixAScalarMultiplicationInput() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getButtonsPanel().getScalarInput();
    }

    public JTextField getMatrixAPowerInput() {
        return frame.getPanel().getPanel().getMatrixA().getPanel().getButtonsPanel().getPowerInput();
    }

    public JButton getMatrixBTranspositionButton() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getButtonsPanel().getTranspositionButton();
    }

    public JButton getMatrixBScalarMultiplicationButton() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getButtonsPanel().getScalarMultiplicationButton();
    }

    public JButton getMatrixBPowerButton() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getButtonsPanel().getPowerButton();
    }

    public JTextField getMatrixBScalarMultiplicationInput() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getButtonsPanel().getScalarInput();
    }

    public JTextField getMatrixBPowerInput() {
        return frame.getPanel().getPanel().getMatrixB().getPanel().getButtonsPanel().getPowerInput();
    }

    public JButton getResultMatrixTranspositionButton() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getButtonsPanel().getTranspositionButton();
    }

    public JButton getResultMatrixScalarMultiplicationButton() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getButtonsPanel().getScalarMultiplicationButton();
    }

    public JButton getResultMatrixPowerButton() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getButtonsPanel().getPowerButton();
    }

    public JTextField getResultMatrixScalarMultiplicationInput() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getButtonsPanel().getScalarInput();
    }

    public JTextField getResultMatrixPowerInput() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getButtonsPanel().getPowerInput();
    }

    public JButton getPasteMatrixAButton() {
        return frame.getPanel().getPastePanel().getPasteMatrixAButton();
    }

    public JButton getPasteMatrixBButton() {
        return frame.getPanel().getPastePanel().getPasteMatrixBButton();
    }

    public JComboBox<Integer> getMatrixARowSelector() {
        return frame.getPanel().getPanel().getMatrixA().getSelectorsPanel().getRowSelector();
    }

    public JComboBox<Integer> getMatrixAColumnSelector() {
        return frame.getPanel().getPanel().getMatrixA().getSelectorsPanel().getColumnSelector();
    }

    public JComboBox<Integer> getMatrixBRowSelector() {
        return frame.getPanel().getPanel().getMatrixB().getSelectorsPanel().getRowSelector();
    }

    public JComboBox<Integer> getMatrixBColumnSelector() {
        return frame.getPanel().getPanel().getMatrixB().getSelectorsPanel().getColumnSelector();
    }
}
