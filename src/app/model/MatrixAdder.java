package app.model;

public final class MatrixAdder {

    public static int[][] addMatrices(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            int[] rowA = a[i];
            int[] rowB = b[i];
            int[] rowNewMatrix = newMatrix[i];

            for (int j = 0; j < a[0].length; j++) {
                rowNewMatrix[j] = rowA[j] + rowB[j];
            }
        }

        return newMatrix;
    }
}
