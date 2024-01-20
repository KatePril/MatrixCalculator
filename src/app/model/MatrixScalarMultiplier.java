package app.model;

import app.iterators.ElementSetterIterator;
import app.iterators.ElementSetterRowIterator;
import app.iterators.RowIterator;

import java.util.Iterator;

public class MatrixScalarMultiplier {

    public static Integer[][] multiplyMatrix(Integer[][] a, Integer scalar) {
        Integer[][] newMatrix = new Integer[a.length][a[0].length];

        ElementSetterIterator<Integer> newMatrixIterator = new ElementSetterRowIterator<>(newMatrix);
        Iterator<Integer> aIterator = new RowIterator<>(a);

        while (newMatrixIterator.hasNext()) {
            Integer value = aIterator.next() * scalar;
            newMatrixIterator.setNext(value);
        }

        return newMatrix;
    }
}
