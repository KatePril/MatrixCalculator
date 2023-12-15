package app.model;

import app.entity.Matrix;

public class MatrixMultiplier extends MatrixOperator{
    public MatrixMultiplier(int size) {
        super(size);
    }

    public int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                int tmp = 0;
                for (int k = 0; k < newMatrix.length; k++) {
                    tmp += a[i][k] * b[k][j];
//                    tmp += a.getElement(i, k) * b.getElement(k, j);
                }
                newMatrix[i][j] = tmp;
//                newMatrix.setElement(i, j, tmp);
            }
        }

        return newMatrix;
    }
}

