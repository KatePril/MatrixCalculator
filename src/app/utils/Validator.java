package app.utils;

public final class Validator {

    public static Boolean isInputValid(String input) {
        return input.matches(Constants.VALIDATION_REGEX);
    }
}
