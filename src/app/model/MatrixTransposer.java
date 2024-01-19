package app.model;

public final class MatrixTransposer {

    public static Integer[][] transposeMatrix(Integer[][] a) {
        Integer[][] newMatrix = new Integer[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            Integer[] rowA = a[i];

            for (int j = 0; j < a.length; j++) {
                newMatrix[j][i] = rowA[j];
            }
        }

        return newMatrix;
    }
}
