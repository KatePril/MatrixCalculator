package app.model;

public class MatrixMultiplier {

    public int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                int tmp = 0;
                for (int k = 0; k < newMatrix.length; k++) {
                    tmp += a[i][k] * b[k][j];
                }
                newMatrix[i][j] = tmp;
            }
        }

        return newMatrix;
    }
}

