package app.utils;

public final class Validator {

    private static boolean isInputValid(String input) {
        return input.matches(Constants.VALIDATION_REGEX);
    }

    public static boolean isArrayValid(String[][] values) {
        for (String[] row : values) {
            for (String element : row) {
                if (!isInputValid(element)) {
                    return false;
                }
            }
        }

        return true;
    }
}
