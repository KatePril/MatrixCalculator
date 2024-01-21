package app.view.elements.panels;

import javax.swing.*;

public class FullMatrixPanel extends JPanel {
    private SelectorsPanel selectorsPanel;
    private MatrixWithButtonsPanel panel;

    public FullMatrixPanel(int rows, int columns) {
        panel = new MatrixWithButtonsPanel(rows, columns);
        selectorsPanel = new SelectorsPanel(rows, columns);

        add(selectorsPanel);
        add(panel);
    }

    public SelectorsPanel getSelectorsPanel() {
        return selectorsPanel;
    }

    public MatrixWithButtonsPanel getPanel() {
        return panel;
    }
}
