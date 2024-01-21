package app.iterators;

public class ElementSetterReverseRowIterator<E> implements ElementSetterIterator<E>{
    private E[][] matrix;

    private int currentElement = 0;
    private final int MAX_ELEMENT;


    public ElementSetterReverseRowIterator(E[][] matrix) {
        this.matrix = matrix;
        this.MAX_ELEMENT = matrix.length * matrix[0].length;
    }

    @Override
    public boolean hasNext() {
        return currentElement < MAX_ELEMENT;
    }

    @Override
    public void setNext(E value) {
        int columnIndex = currentElement / matrix[0].length;
        int rowIndex = currentElement - (matrix[0].length * columnIndex);
        currentElement++;

        matrix[rowIndex][columnIndex] = value;
    }
}
