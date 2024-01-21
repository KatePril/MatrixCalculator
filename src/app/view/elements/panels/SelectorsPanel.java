package app.view.elements.panels;

import app.view.elements.SizeSelector;

import javax.swing.*;

public class SelectorsPanel extends JPanel {

    private JComboBox<Integer> rowSelector;
    private JComboBox<Integer> columnSelector;

    public SelectorsPanel(int rows, int columns) {
        rowSelector = new SizeSelector(rows);
        columnSelector = new SizeSelector(columns);

        add(rowSelector);
        add(columnSelector);
    }

    public JComboBox<Integer> getRowSelector() {
        return rowSelector;
    }

    public JComboBox<Integer> getColumnSelector() {
        return columnSelector;
    }
}
