package app.entity;

import app.view.elements.MatrixInput;

import javax.swing.*;

public class VisualMatrix {
    private final int SIZE;
    private MatrixInput[][] fields;

    public VisualMatrix(int size) {
        this.SIZE = size;
        fields = new MatrixInput[size][size];
        for (int i = 0; i < size; i++) {
            MatrixInput[] row = fields[i];

            for (int j = 0; j < size; j++) {
                row[j] = new MatrixInput(0);
            }
        }
    }

    public String[][] getValues() {
        String[][] values = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            MatrixInput[] fieldsRow = fields[i];
            String[] valuesRow = values[i];

            for (int j = 0; j < SIZE; j++) {
                if (fieldsRow[j].getText().trim().isEmpty()) {
                    valuesRow[j] = "0";
                } else {
                    valuesRow[j] = fieldsRow[j].getText();
                }
            }
        }
        return values;
    }

    public void fillFields(int[][] values) {
        for (int i = 0; i < SIZE; i++) {
            MatrixInput[] row = fields[i];
            int[] valuesRow = values[i];

            for (int j = 0; j < SIZE; j++) {
                row[j].setText(Integer.toString(valuesRow[j]));
            }
        }
    }

    public void drawMatrix(JPanel panel) {
        for (int i = 0; i < SIZE; i++) {
            MatrixInput[] row = fields[i];

            for (int j = 0; j < SIZE; j++) {
                panel.add(row[j]);
            }
        }
    }
}
