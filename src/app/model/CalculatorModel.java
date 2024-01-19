package app.model;

public class CalculatorModel {

    public Integer[][] addMatrices(Integer[][] a, Integer[][] b) {
        return MatrixAdder.addMatrices(a, b);
    }

    public Integer[][] multiplyMatrices(Integer[][] a, Integer[][] b) {
        return MatrixMultiplier.multiplyMatrices(a, b);
    }

    public Integer[][] subtractMatrices(Integer[][] a, Integer[][] b) {
        return MatrixSubtracter.subtractMatrices(a, b);
    }

    public Integer[][] transposeMatrix(Integer[][] a) {
        return MatrixTransposer.transposeMatrix(a);
    }
}
