package app.model;

public class CalculatorModel {

    private final MatrixAdder matrixAdder;
    private final MatrixMultiplier matrixMultiplier;
    private final MatrixSubtracter matrixSubtracter;
    private final MatrixTransposer matrixTransposer;

    public CalculatorModel() {
        this.matrixAdder = new MatrixAdder();
        this.matrixMultiplier = new MatrixMultiplier();
        this.matrixSubtracter = new MatrixSubtracter();
        this.matrixTransposer = new MatrixTransposer();
    }

    public MatrixAdder getMatrixAdder() {
        return matrixAdder;
    }

    public MatrixMultiplier getMatrixMultiplier() {
        return matrixMultiplier;
    }

    public MatrixSubtracter getMatrixSubtracter() {
        return matrixSubtracter;
    }

    public MatrixTransposer getMatrixTransposer() {
        return matrixTransposer;
    }
}
