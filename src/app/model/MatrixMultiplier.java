package app.model;

import app.entity.Matrix;

public class MatrixMultiplier extends MatrixOperator{
    public MatrixMultiplier(int size) {
        super(size);
    }

    public void multiplyMatrix(Matrix a, Matrix b) {
        for (int i = 0; i < newMatrix.getSize(); i++) {
            for (int j = 0; j < newMatrix.getSize(); j++) {
                int tmp = 0;
                for (int k = 0; k < newMatrix.getSize(); k++) {
                    tmp += a.getElement(i, k) * b.getElement(k, j);
                }
                newMatrix.setElement(i, j, tmp);
            }
        }
    }
}

