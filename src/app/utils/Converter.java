package app.utils;

import app.iterators.ElementSetterIterator;
import app.iterators.ElementSetterRowIterator;
import app.iterators.RowIterator;

import java.util.Iterator;

public final class Converter {

    public static Integer[][] convertStringArrayToIntArray(String[][] strArray) {
        Integer[][] intArray = new Integer[strArray.length][strArray[0].length];

        ElementSetterIterator<Integer> intArrayIterator = new ElementSetterRowIterator<>(intArray);
        Iterator<String> strArrayIterator = new RowIterator<>(strArray);

        while (intArrayIterator.hasNext()) {
            Integer value = Integer.parseInt(strArrayIterator.next());
            intArrayIterator.setNext(value);
        }

        return intArray;
    }
}
