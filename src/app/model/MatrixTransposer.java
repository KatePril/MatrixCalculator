package app.model;

import app.iterators.ElementSetterIterator;
import app.iterators.ElementSetterReverseRowIterator;
import app.iterators.RowIterator;

import java.util.Iterator;

public final class MatrixTransposer {

    public static Integer[][] transposeMatrix(Integer[][] a) {
        Integer[][] newMatrix = new Integer[a.length][a.length];

        ElementSetterIterator<Integer> newMatrixIterator = new ElementSetterReverseRowIterator<>(newMatrix);
        Iterator<Integer> aIterator = new RowIterator<>(a);

        while (newMatrixIterator.hasNext()) {
            newMatrixIterator.setNext(aIterator.next());
        }

        return newMatrix;
    }
}
