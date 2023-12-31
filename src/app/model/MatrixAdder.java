package app.model;

public class MatrixAdder {

    public int[][] addMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                newMatrix[i][j] = a[i][j] + b[i][j];
            }
        }

        return newMatrix;
    }
}
