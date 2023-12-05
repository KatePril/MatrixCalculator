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
            for (int j = 0; j < size; j++) {
                fields[i][j] = new MatrixInput(0, i, j);
            }
        }
    }

    public int[][] getValues() {
        int[][] values = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (fields[i][j].getText().trim().isEmpty()) {
                    values[i][j] = 0;
                } else {
                    try {
                        values[i][j] = Integer.parseInt(fields[i][j].getText());
                    } catch (NumberFormatException e) {
                        throw new RuntimeException();
                    }
                }
            }
        }
        return values;
    }

    public void drawMatrix(JPanel panel) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                panel.add(fields[i][j]);
            }
        }
    }

    public int getSize() {
        return SIZE;
    }

    public MatrixInput[][] getFields() {
        return fields;
    }

    public void setFields(MatrixInput[][] fields) {
        this.fields = fields;
    }
}