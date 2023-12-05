package app.model;

import app.entity.Matrix;

public class MatrixSubtracter extends MatrixOperator {

    public MatrixSubtracter(int size) {
        super(size);
    }

    public void subtractMatrix(Matrix a, Matrix b) {
        for (int i = 0; i < newMatrix.getSize(); i++) {
            for (int j = 0; j < newMatrix.getSize(); j++) {
                newMatrix.setElement(i, j, a.getElement(i, j) - b.getElement(i, j));
            }
        }
    }
}
