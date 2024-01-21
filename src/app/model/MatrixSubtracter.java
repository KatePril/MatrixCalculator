package app.model;

import app.iterators.ElementSetterIterator;
import app.iterators.ElementSetterRowIterator;
import app.iterators.RowIterator;

import java.util.Iterator;

public final class MatrixSubtracter {

    public static Integer[][] subtractMatrices(Integer[][] a, Integer[][] b) {
        Integer[][] newMatrix = new Integer[a.length][a[0].length];

        ElementSetterIterator<Integer> newMatrixIterator = new ElementSetterRowIterator<>(newMatrix);
        Iterator<Integer> aIterator = new RowIterator<>(a);
        Iterator<Integer> bIterator = new RowIterator<>(b);

        while (newMatrixIterator.hasNext()) {
            Integer value = aIterator.next() - bIterator.next();
            newMatrixIterator.setNext(value);
        }

        return newMatrix;
    }
}
