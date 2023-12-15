package app.model;

public class CalculatorModel {
    private int size;

    private MatrixAdder matrixAdder;
    private MatrixMultiplier matrixMultiplier;
    private MatrixSubtracter matrixSubtracter;
    private MatrixTransposer matrixTransposer;

    public CalculatorModel() {
        size = 2;
        matrixAdder = new MatrixAdder(size);
        matrixMultiplier = new MatrixMultiplier(size);
        matrixSubtracter = new MatrixSubtracter(size);
        matrixTransposer = new MatrixTransposer(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        matrixAdder = new MatrixAdder(size);
        matrixMultiplier = new MatrixMultiplier(size);
        matrixSubtracter = new MatrixSubtracter(size);
        matrixTransposer = new MatrixTransposer(size);
    }
}
