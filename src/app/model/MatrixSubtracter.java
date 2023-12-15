package app.model;

import app.entity.Matrix;

public class MatrixSubtracter extends MatrixOperator {

    public MatrixSubtracter(int size) {
        super(size);
    }

    public int[][] subtractMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                newMatrix[i][j] = a[i][j] - b[i][j];
                System.out.printf("newMatrix[%d][%d] = %d - %d", i, j, a[i][j], b[i][j]);
            }
        }
        return newMatrix;
    }
}
