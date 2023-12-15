package app.utils;

public final class Converter {

    public static int[][] convertStringArrayToIntegerArray(String[][] strArray) {
        int[][] intArray = new int[strArray.length][strArray[0].length];

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[0].length; j++) {
                intArray[i][j] = Integer.parseInt(strArray[i][j]);
            }
        }

        return intArray;
    }
}
