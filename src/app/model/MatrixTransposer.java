package app.model;

public class MatrixTransposer {

    public int[][] transposeMatrix(int[][] a) {
        int[][] newMatrix = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                newMatrix[j][i] = a[i][j];
            }
        }

        return newMatrix;
    }
}
