package app.view;
import app.view.elements.CalculatorFrame;

import javax.swing.*;

public class CalculatorView {
    CalculatorFrame frame;

    public CalculatorView() {
        frame = new CalculatorFrame("Calculator");
        frame.getPanel().getSizeSelector().addActionListener(l -> {
            frame.getPanel().getPanel().changeSize((Integer) frame.getPanel().getSizeSelector().getSelectedItem());
            System.out.println(frame.getPanel().getSizeSelector().getSelectedItem());

        });
    }


    public int[][] getMatrixAFields() {
        return frame.getPanel().getPanel().getMatrixA().getMatrix().getMatrix().getValues();
    }

    public int[][] getMatrixBFields() {
        return frame.getPanel().getPanel().getMatrixB().getMatrix().getMatrix().getValues();
    }

    public void setResultMatrixFields(int[][] fields) {
        frame.getPanel().getPanel().getResultMatrix().getMatrix().getMatrix().getMatrix().fillFields(fields);
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

}
