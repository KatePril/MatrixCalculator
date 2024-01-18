package app.utils;

public final class Converter {

    public static int[][] convertStringArrayToIntArray(String[][] strArray) {
        int[][] intArray = new int[strArray.length][strArray[0].length];

        for (int i = 0; i < strArray.length; i++) {
            String[] rowStrArray = strArray[i];
            int[] rowIntArray = intArray[i];

            for (int j = 0; j < strArray[0].length; j++) {
                rowIntArray[j] = Integer.parseInt(rowStrArray[j]);
            }
        }

        return intArray;
    }
}
