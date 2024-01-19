package app.iterators;

import java.util.Iterator;

public class ReverseRowIterator<E> implements Iterator<E> {
    private E[][] matrix;

    private int currentElement = 0;
    private final int MAX_ELEMENT;

    public ReverseRowIterator(E[][] matrix) {
        this.matrix = matrix;
        this.MAX_ELEMENT = matrix.length * matrix[0].length;
    }

    @Override
    public boolean hasNext() {
        return currentElement < MAX_ELEMENT;
    }

    @Override
    public E next() {
        int columnIndex = currentElement / matrix.length;
        int rowIndex = currentElement - (matrix.length * columnIndex);
        currentElement++;

        return matrix[rowIndex][columnIndex];
    }
}
