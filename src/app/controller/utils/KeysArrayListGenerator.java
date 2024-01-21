package app.controller.utils;

import app.enums.Actions;
import app.enums.Matrices;
import app.enums.Sizes;

import java.util.ArrayList;

public final class KeysArrayListGenerator {

    public static ArrayList<String> getMatricesKeys() {
        ArrayList<String> matricesKeys = new ArrayList<>();

        matricesKeys.add(Matrices.MATRIX_A.name());
        matricesKeys.add(Matrices.MATRIX_B.name());
//        matricesKeys.add(Matrices.RESULT_MATRIX.name());

        return matricesKeys;
    }

    public static ArrayList<String> getButtonsKeys() {
        ArrayList<String> buttonsKeys = new ArrayList<>();

        buttonsKeys.add(Actions.ADD.name());
        buttonsKeys.add(Actions.MULTIPLY.name());
        buttonsKeys.add(Actions.SUBTRACT.name());

        buttonsKeys.add(Actions.TRANSPOSE.name() + "_" + Matrices.MATRIX_A.name());
        buttonsKeys.add(Actions.TRANSPOSE.name() + "_" + Matrices.MATRIX_B.name());
//        buttonsKeys.add(Actions.TRANSPOSE.name() + "_" + Matrices.RESULT_MATRIX.name());

        fillArrays(buttonsKeys);

        buttonsKeys.add(Actions.PASTE.name() + "_" + Matrices.MATRIX_A.name());
        buttonsKeys.add(Actions.PASTE.name() + "_" + Matrices.MATRIX_B.name());

        return buttonsKeys;
    }

    public static ArrayList<String> getNoArgActionsKeys() {
        ArrayList<String> actionsKeys = new ArrayList<>();

        actionsKeys.add(Actions.ADD.name());
        actionsKeys.add(Actions.MULTIPLY.name());
        actionsKeys.add(Actions.SUBTRACT.name());

        return actionsKeys;
    }

    public static ArrayList<String> getActionsKeys() {
        ArrayList<String> actionsKeys = new ArrayList<>();

        actionsKeys.add(Actions.TRANSPOSE.name());
        actionsKeys.add(Actions.PASTE.name());

        return actionsKeys;
    }

    public static ArrayList<String> getBiActionsKeys() {
        ArrayList<String> actionsKeys = new ArrayList<>();

        actionsKeys.add(Actions.SCALAR_MULTIPLY.name());
        actionsKeys.add(Actions.POWER.name());

        return actionsKeys;
    }

    public static ArrayList<String> getInputKeys() {
        ArrayList<String> inputsKeys = new ArrayList<>();

        fillArrays(inputsKeys);

        return inputsKeys;
    }

    private static void fillArrays(ArrayList<String> array) {
        array.add(Actions.SCALAR_MULTIPLY.name() + "_" + Matrices.MATRIX_A.name());
        array.add(Actions.SCALAR_MULTIPLY.name() + "_" + Matrices.MATRIX_B.name());
//        array.add(Actions.SCALAR_MULTIPLY.name() + "_" + Matrices.RESULT_MATRIX.name());

        array.add(Actions.POWER.name() + "_" + Matrices.MATRIX_A.name());
        array.add(Actions.POWER.name() + "_" + Matrices.MATRIX_B.name());
//        array.add(Actions.POWER.name() + "_" + Matrices.RESULT_MATRIX.name());
    }

    public static ArrayList<String> getSizesKeys() {
        ArrayList<String> sizeKeys = new ArrayList<>();

        sizeKeys.add(Sizes.MATRIX_A_ROWS.name());
        sizeKeys.add(Sizes.MATRIX_A_COLUMNS.name());
        sizeKeys.add(Sizes.MATRIX_B_ROWS.name());
        sizeKeys.add(Sizes.MATRIX_B_COLUMNS.name());

        return sizeKeys;
    }


}
