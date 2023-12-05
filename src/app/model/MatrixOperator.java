package app.model;

import app.entity.Matrix;

public class MatrixOperator {
    protected Matrix newMatrix;

    public MatrixOperator(int size) {
        newMatrix = new Matrix(size);
    }

    public void setMatrixSize(int size) {
        newMatrix = new Matrix(size);
    }

    public Matrix getNewMatrix() {
        return newMatrix;
    }

    public void setNewMatrix(Matrix newMatrix) {
        this.newMatrix = newMatrix;
    }
}
