package app.model;

import app.entity.Matrix;

public class MatrixTransposer extends MatrixOperator{
    public MatrixTransposer(int size) {
        super(size);
    }

    public void transposeMatrix(Matrix a) {
        for (int i = 0; i < newMatrix.getSize(); i++) {
            for (int j = 0; j < newMatrix.getSize(); j++) {
                newMatrix.setElement(j, i, a.getElement(i, j));
            }
        }
    }
}
