package app.model;

public final class MatrixSubtracter {

    public static Integer[][] subtractMatrices(Integer[][] a, Integer[][] b) {
        Integer[][] newMatrix = new Integer[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            Integer[] rowA = a[i];
            Integer[] rowB = b[i];
            Integer[] rowNewMatrix = newMatrix[i];

            for (int j = 0; j < a[0].length; j++) {
                rowNewMatrix[j] = rowA[j] - rowB[j];
            }
        }
        return newMatrix;
    }
}
