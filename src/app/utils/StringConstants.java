package app.utils;

public final class StringConstants {
    public final static String INCORRECT_MATRIX_INPUT_MSG = "Some matrix inputs are not valid. Make sure all entered numbers are integers, " +
            "please, before clicking on the buttons again";

    public final static String INCORRECT_POWER_MSG = "The power of the matrix can be a non-negative integer greater than one";

    public final static String INCORRECT_SCALAR_MSG = "Matrices can be multiplied by integers only. Check entered number," +
            " please, before clicking on the buttons again";

    public final static String VALIDATION_REGEX = "[-]?\\d+";

    public final static String POWER_VALIDATION_REGEX = "[2-9]\\d*|1\\d+[1-9]";
}
