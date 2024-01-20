package app.model;

public class MatrixPowerer {

    public static Integer[][] powerMatrix(Integer[][] a, Integer power) {
        Integer[][] newMatrix = MatrixMultiplier.multiplyMatrices(a, a);

        for (int i = 2; i < power; i++) {
            newMatrix = MatrixMultiplier.multiplyMatrices(newMatrix, a);
        }

        return newMatrix;
    }
}
