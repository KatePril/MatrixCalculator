package app.entity;

import app.iterators.ElementSetterIterator;
import app.iterators.ElementSetterRowIterator;
import app.iterators.RowIterator;
import app.view.elements.MatrixInput;

import javax.swing.*;
import java.util.Iterator;

public class VisualMatrix {
    private final int SIZE;
    private MatrixInput[][] fields;

    public VisualMatrix(int size) {
        this.SIZE = size;
        fields = new MatrixInput[size][size];
        ElementSetterIterator<MatrixInput> iterator = new ElementSetterRowIterator<>(fields);

        while(iterator.hasNext()) {
            iterator.setNext(new MatrixInput(0));
        }

//        for (int i = 0; i < size; i++) {
//            MatrixInput[] row = fields[i];
//
//            for (int j = 0; j < size; j++) {
//                row[j] = new MatrixInput(0);
//            }
//        }
    }

    public String[][] getValues() {
        String[][] values = new String[SIZE][SIZE];
        Iterator<MatrixInput> fieldsIterator = new RowIterator<>(fields);
        ElementSetterIterator<String> valuesIterator = new ElementSetterRowIterator<>(values);

        while (fieldsIterator.hasNext()) {
            String value = fieldsIterator.next().getText();
            if (value.trim().isEmpty()) {
                valuesIterator.setNext("0");
            } else {
                valuesIterator.setNext(value);
            }
        }

//        for (int i = 0; i < SIZE; i++) {
//            MatrixInput[] fieldsRow = fields[i];
//            String[] valuesRow = values[i];
//
//            for (int j = 0; j < SIZE; j++) {
//                if (fieldsRow[j].getText().trim().isEmpty()) {
//                    valuesRow[j] = "0";
//                } else {
//                    valuesRow[j] = fieldsRow[j].getText();
//                }
//            }
//        }
        return values;
    }

    public void fillFields(Integer[][] values) {
        Iterator<Integer> valuesIterator = new RowIterator<>(values);
        Iterator<MatrixInput> fieldsIterator = new RowIterator<>(fields);

        while (valuesIterator.hasNext()) {
            String value = Integer.toString(valuesIterator.next());
            fieldsIterator.next().setText(value);
        }

//        for (int i = 0; i < SIZE; i++) {
//            MatrixInput[] row = fields[i];
//            int[] valuesRow = values[i];
//
//            for (int j = 0; j < SIZE; j++) {
//                row[j].setText(Integer.toString(valuesRow[j]));
//            }
//        }
    }

    public void drawMatrix(JPanel panel) {
        Iterator<MatrixInput> fieldsIterator = new RowIterator<>(fields);

        while (fieldsIterator.hasNext()) {
            panel.add(fieldsIterator.next());
        }

//        for (int i = 0; i < SIZE; i++) {
//            MatrixInput[] row = fields[i];
//
//            for (int j = 0; j < SIZE; j++) {
//                panel.add(row[j]);
//            }
//        }
    }
}
