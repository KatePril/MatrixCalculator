package app.model;

import app.entity.Matrix;

public class MatrixSubtracter extends MatrixOperator {

    public MatrixSubtracter(int size) {
        super(size);
    }

    public int[][] subtractMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                newMatrix[i][j] = a[i][j] - b[i][j];
//                newMatrix.setElement(i, j, a.getElement(i, j) - b.getElement(i, j));
            }
        }
        return newMatrix;
    }
}
