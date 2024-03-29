package app.controller.utils;

import app.entity.VisualMatrix;
import app.model.CalculatorModel;
import app.utils.HashMapFiller;
import app.utils.Validator;
import app.view.CalculatorView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class HashMapsGenerator {

    public static HashMap<String, VisualMatrix> getMatricesHashMap(CalculatorView view) {
        HashMapFiller<String, VisualMatrix> matrixHashMapFiller = new HashMapFiller<>();

        ArrayList<String> matricesKeys = KeysArrayListGenerator.getMatricesKeys();
        ArrayList<VisualMatrix> matrices = ValuesArrayListGenerator.getMatricesValues(view);

        HashMap<String, VisualMatrix> output = matrixHashMapFiller.fillNewHashMap(matricesKeys, matrices);

        return output;
    }

    public static HashMap<String, JButton> getButtonsHashMap(CalculatorView view) {
        HashMapFiller<String, JButton> buttonHashMapFiller = new HashMapFiller<>();

        ArrayList<String> buttonsKeys = KeysArrayListGenerator.getButtonsKeys();
        ArrayList<JButton> buttons = ValuesArrayListGenerator.getButtonsValues(view);

        HashMap<String, JButton> output = buttonHashMapFiller.fillNewHashMap(buttonsKeys, buttons);

        return output;
    }

    public static HashMap<String, JTextField> getInputsHashMap(CalculatorView view) {
        HashMapFiller<String, JTextField> inputsHashMapFiller = new HashMapFiller<>();

        ArrayList<String> inputsKeys = KeysArrayListGenerator.getInputKeys();
        ArrayList<JTextField> inputs = ValuesArrayListGenerator.getInputsValues(view);

        HashMap<String, JTextField> output = inputsHashMapFiller.fillNewHashMap(inputsKeys, inputs);

        return output;
    }

    public static HashMap<String, Consumer<VisualMatrix>> getFunctionsHashMap(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        HashMapFiller<String, Consumer<VisualMatrix>> functionsHashMapFiller = new HashMapFiller<>();

        ArrayList<String> actionsKeys = KeysArrayListGenerator.getActionsKeys();
        ArrayList<Consumer<VisualMatrix>> functions = ValuesArrayListGenerator.getFunctionsValues(model, matrices);

        HashMap<String, Consumer<VisualMatrix>> output = functionsHashMapFiller.fillNewHashMap(actionsKeys, functions);

        return output;
    }

    public static HashMap<String, BiConsumer<VisualMatrix, String>> getBiFunctionsHashMap(CalculatorModel model, HashMap<String, VisualMatrix> matrices) {
        HashMapFiller<String, BiConsumer<VisualMatrix, String>> biFunctionsHashMapFiller = new HashMapFiller<>();

        ArrayList<String> biActionsKeys = KeysArrayListGenerator.getBiActionsKeys();
        ArrayList<BiConsumer<VisualMatrix, String>> biFunctions = ValuesArrayListGenerator.getBiFunctionsValues(model, matrices);

        HashMap<String, BiConsumer<VisualMatrix, String>> output = biFunctionsHashMapFiller.fillNewHashMap(biActionsKeys, biFunctions);

        return output;
    }

    public static HashMap<String, Predicate<String>> getValidationHashMap() {
        HashMapFiller<String, Predicate<String>> validationHashMapFiller = new HashMapFiller<>();

        ArrayList<String> biActionsKeys = KeysArrayListGenerator.getBiActionsKeys();
        ArrayList<Predicate<String>> validationArray = ValuesArrayListGenerator.getValidationValues();

        HashMap<String, Predicate<String>> output = validationHashMapFiller.fillNewHashMap(biActionsKeys, validationArray);

        return output;
    }

    public static HashMap<String, String> getMsgValidationHashMap() {
        HashMapFiller<String, String> validationHashMapFiller = new HashMapFiller<>();

        ArrayList<String> biActionsKeys = KeysArrayListGenerator.getBiActionsKeys();
        ArrayList<String> validationArray = ValuesArrayListGenerator.getValidationMsgValues();

        HashMap<String, String> output = validationHashMapFiller.fillNewHashMap(biActionsKeys, validationArray);

        return output;
    }

}
