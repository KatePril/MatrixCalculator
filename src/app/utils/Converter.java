package app.utils;

public final class Converter {

    public static Integer[][] convertStringArrayToIntArray(String[][] strArray) {
        Integer[][] intArray = new Integer[strArray.length][strArray[0].length];

        for (int i = 0; i < strArray.length; i++) {
            String[] rowStrArray = strArray[i];
            Integer[] rowIntArray = intArray[i];

            for (int j = 0; j < strArray[0].length; j++) {
                rowIntArray[j] = Integer.parseInt(rowStrArray[j]);
            }
        }

        return intArray;
    }
}
