package app.view.elements.panels;


import javax.swing.*;
import java.awt.*;

public class FullMatrixPanel extends JPanel {
    private MatrixButtonsPanel buttonsPanel;
    private SelectorsPanel selectorsPanel;
    private MatrixPanel matrix;

    public FullMatrixPanel(int size) {
        matrix = new MatrixPanel(size);
        buttonsPanel = new MatrixButtonsPanel(matrix.getWidth());
        selectorsPanel = new SelectorsPanel(size, size);

        setPreferredSize(new Dimension(matrix.getWidth(), matrix.getHeight() + buttonsPanel.getHEIGHT() + 50));

        add(selectorsPanel);
        add(matrix);
        add(buttonsPanel);
    }

    public SelectorsPanel getSelectorsPanel() {
        return selectorsPanel;
    }

    public MatrixButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public MatrixPanel getMatrix() {
        return matrix;
    }
}
