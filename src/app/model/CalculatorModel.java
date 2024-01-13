package app.model;

public class CalculatorModel {

    public int[][] addMatrices(int[][] a, int[][] b) {
        return MatrixAdder.addMatrices(a, b);
    }

    public int[][] multiplyMatrices(int[][] a, int[][] b) {
        return MatrixMultiplier.multiplyMatrices(a, b);
    }

    public int[][] subtractMatrices(int[][] a, int[][] b) {
        return MatrixSubtracter.subtractMatrices(a, b);
    }

    public int[][] transposeMatrix(int[][] a) {
        return MatrixTransposer.transposeMatrix(a);
    }
}
