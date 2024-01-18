package app.model;

public final class MatrixTransposer {

    public static int[][] transposeMatrix(int[][] a) {
        int[][] newMatrix = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            int[] rowA = a[i];

            for (int j = 0; j < a.length; j++) {
                newMatrix[j][i] = rowA[j];
            }
        }

        return newMatrix;
    }
}
