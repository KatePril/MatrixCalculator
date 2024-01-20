package app.utils;

import app.iterators.RowIterator;

import java.util.Iterator;

public final class Validator {

    public static boolean isInputValid(String input) {
        return input.matches(StringConstants.VALIDATION_REGEX);
    }

    public static boolean isArrayValid(String[][] values) {
        Iterator<String> iterator = new RowIterator<>(values);

        while (iterator.hasNext()) {
            if (!isInputValid(iterator.next())) {
                return false;
            }
        }

        return true;
    }
}
