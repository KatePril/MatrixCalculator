package app.entity;

import app.iterators.ElementSetterIterator;
import app.iterators.ElementSetterRowIterator;
import app.iterators.RowIterator;
import app.view.elements.inputs.MatrixElementInput;

import javax.swing.*;
import java.util.Iterator;

public class VisualMatrix {
    private final int ROWS;
    private final int COLUMNS;
    private MatrixElementInput[][] fields;

    public VisualMatrix(int rows, int columns) {
        this.ROWS = rows;
        this.COLUMNS = columns;
        fields = new MatrixElementInput[rows][columns];
        ElementSetterIterator<MatrixElementInput> iterator = new ElementSetterRowIterator<>(fields);

        while(iterator.hasNext()) {
            iterator.setNext(new MatrixElementInput());
        }
    }

    public String[][] getValues() {
        String[][] values = new String[ROWS][COLUMNS];
        Iterator<MatrixElementInput> fieldsIterator = new RowIterator<>(fields);
        ElementSetterIterator<String> valuesIterator = new ElementSetterRowIterator<>(values);

        while (fieldsIterator.hasNext()) {
            String value = fieldsIterator.next().getText();
            if (value.trim().isEmpty()) {
                valuesIterator.setNext("0");
            } else {
                valuesIterator.setNext(value);
            }
        }

        return values;
    }

    public void fillFields(Integer[][] values) {
        Iterator<Integer> valuesIterator = new RowIterator<>(values);
        Iterator<MatrixElementInput> fieldsIterator = new RowIterator<>(fields);

        while (valuesIterator.hasNext()) {
            String value = Integer.toString(valuesIterator.next());
            fieldsIterator.next().setText(value);
        }
    }

    public void drawMatrix(JPanel panel) {
        Iterator<MatrixElementInput> fieldsIterator = new RowIterator<>(fields);

        while (fieldsIterator.hasNext()) {
            panel.add(fieldsIterator.next());
        }
    }
}
