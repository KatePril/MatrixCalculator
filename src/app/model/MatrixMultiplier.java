package app.model;

public final class MatrixMultiplier {

    public static Integer[][] multiplyMatrices(Integer[][] a, Integer[][] b) {
        Integer[][] newMatrix = new Integer[a.length][a[0].length];

        for (int i = 0; i < newMatrix.length; i++) {
            Integer[] rowA = a[i];
            Integer[] rowNewMatrix = newMatrix[i];

            for (int j = 0; j < newMatrix.length; j++) {
                int tmp = 0;

                for (int k = 0; k < newMatrix.length; k++) {
                    tmp += rowA[k] * b[k][j];
                }
                rowNewMatrix[j] = tmp;
            }
        }

        return newMatrix;
    }
}

