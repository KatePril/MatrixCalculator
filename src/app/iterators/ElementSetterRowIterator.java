package app.iterators;

public class ElementSetterRowIterator<E> {
    private E[][] matrix;

    private int currentElement = 0;
    private final int MAX_ELEMENT;

    public ElementSetterRowIterator(E[][] matrix) {
        this.matrix = matrix;
        this.MAX_ELEMENT = matrix.length * matrix[0].length;
    }

    public void setNext(E value) {
        int rowIndex = currentElement / matrix.length;
        int columnIndex = currentElement - (matrix.length * rowIndex);
        currentElement++;

        matrix[rowIndex][columnIndex] = value;
    }

    public boolean hasNext() {
        return currentElement < MAX_ELEMENT;
    }
}
