package app.utils;

import app.iterators.RowIterator;

import java.util.Iterator;

public final class Validator {

    public static boolean isScalarValid(String input) {
        return input.matches(StringConstants.VALIDATION_REGEX);
    }

    public static boolean isArrayValid(String[][] values) {
        Iterator<String> iterator = new RowIterator<>(values);

        while (iterator.hasNext()) {
            if (!isScalarValid(iterator.next())) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPowerValid(String input) {
        return input.matches(StringConstants.POWER_VALIDATION_REGEX);
    }
}
