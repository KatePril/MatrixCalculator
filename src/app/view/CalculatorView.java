package app.view;

import app.entity.VisualMatrix;
import app.view.elements.CalculatorFrame;
import app.view.elements.panels.CalculatorMatrixPanel;

import javax.swing.*;

public class CalculatorView {
    CalculatorFrame frame;

    public CalculatorView(int size) {
        frame = new CalculatorFrame("Calculator", size);
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
        return frame.getPanel().getPanel().getMatrixA().getButton();
    }

    public JButton getMatrixBTranspositionButton() {
        return frame.getPanel().getPanel().getMatrixB().getButton();
    }

    public JButton getResultMatrixTranspositionButton() {
        return frame.getPanel().getPanel().getResultMatrix().getMatrix().getButton();
    }

    public JButton getPasteAButton() {
        return frame.getPanel().getPastePanel().getPasteAButton();
    }

    public JButton getPasteBButton() {
        return frame.getPanel().getPastePanel().getPasteBButton();
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
}
