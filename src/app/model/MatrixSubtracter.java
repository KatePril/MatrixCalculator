package app.model;

public final class MatrixSubtracter {

    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                newMatrix[i][j] = a[i][j] - b[i][j];
            }
        }
        return newMatrix;
    }
}
