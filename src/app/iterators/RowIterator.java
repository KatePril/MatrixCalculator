package app.iterators;

import java.util.Iterator;

public class RowIterator<E> implements Iterator<E> {
    private E[][] matrix;

    private int currentElement = 0;
    private final int MAX_ELEMENT;

    public RowIterator(E[][] matrix) {
        this.matrix = matrix;
        this.MAX_ELEMENT = matrix.length * matrix[0].length;
    }

    @Override
    public boolean hasNext() {
        return currentElement < MAX_ELEMENT;
    }

    @Override
    public E next() {
        int rowIndex = currentElement / matrix.length;
        int columnIndex = currentElement - (matrix.length * rowIndex);
        currentElement++;

        return matrix[rowIndex][columnIndex];
    }
}
