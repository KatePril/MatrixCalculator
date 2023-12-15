package app.model;

import app.entity.Matrix;

public class MatrixTransposer extends MatrixOperator{
    public MatrixTransposer(int size) {
        super(size);
    }

    public int[][] transposeMatrix(int[][] a) {
        int[][] newMatrix = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                newMatrix[j][i] = a[i][j];
//                newMatrix.setElement(j, i, a.getElement(i, j));
            }
        }

        return newMatrix;
    }
}
