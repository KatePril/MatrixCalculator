package app.iterators;

public class ElementSetterRowIterator<E> implements ElementSetterIterator<E> {
    private E[][] matrix;

    private int currentElement = 0;
    private final int MAX_ELEMENT;

    public ElementSetterRowIterator(E[][] matrix) {
        this.matrix = matrix;
        this.MAX_ELEMENT = matrix.length * matrix[0].length;
    }

    @Override
    public void setNext(E value) {
        int rowIndex = currentElement / matrix[0].length;
        int columnIndex = currentElement - (matrix[0].length * rowIndex);
        currentElement++;

        matrix[rowIndex][columnIndex] = value;
    }

    @Override
    public boolean hasNext() {
        return currentElement < MAX_ELEMENT;
    }
}
