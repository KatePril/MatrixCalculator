package app.entity;

public class Matrix {
    private final int size;
    private int[][] values;

    public Matrix(int size) {
        this.size = size;
        values = new int[size][size];
    }

    public Matrix(int[][] values) {
        this.values = values;
        this.size = values.length;
    }

    public int getSize() {
        return size;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public void setElement(int i, int j, int value) {
        values[i][j] = value;
    }
    public int getElement(int i, int j) {
        return values[i][j];
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                output.append(values[i][j]).append("\t");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
