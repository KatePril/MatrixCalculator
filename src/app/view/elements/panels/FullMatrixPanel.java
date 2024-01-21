package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class FullMatrixPanel extends JPanel {
    private SelectorsPanel selectorsPanel;
    private MatrixWithButtonsPanel panel;

    public FullMatrixPanel(int rows, int columns) {
        panel = new MatrixWithButtonsPanel(rows, columns);
        selectorsPanel = new SelectorsPanel(rows, columns);

        setPreferredSize(new Dimension(panel.getWIDTH(), panel.getHEIGHT()));

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
