package app.controller;

import app.controller.utils.HashMapsGenerator;
import app.controller.utils.KeysArrayListGenerator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SizeController {
    private CalculatorController calculatorController;
    private HashMap<String, JComboBox<Integer>> sizeSelectorsHashMap;
    public SizeController() {
        createController(getInitialSizes());
    }

    private void deleteFrame() {
        if (calculatorController.getCalculatorFrame() != null) {
            calculatorController.getCalculatorFrame().setVisible(false);
            calculatorController.getCalculatorFrame().dispose();
        }
    }

    private void addActionListeners () {
        ArrayList<String> keys = KeysArrayListGenerator.getSizesKeys();
        for (String key : keys) {
            changeSize(sizeSelectorsHashMap.get(key));
        }
    }

    private void changeSize(JComboBox<Integer> selector) {
        selector.addItemListener(l -> {
            deleteFrame();
            createController(getSizes());
        });
    }

    private void createController(HashMap<String, Integer> sizes) {
        this.calculatorController = new CalculatorController(sizes);
        this.sizeSelectorsHashMap = HashMapsGenerator.getSizeSelectorsHashMap(calculatorController);
        addActionListeners();
    }

    private HashMap<String, Integer> getSizes() {
        ArrayList<String> keys = KeysArrayListGenerator.getSizesKeys();
        HashMap<String, Integer> sizesHashMap = new HashMap<>();

        for (String key : keys) {
            int size = (Integer) sizeSelectorsHashMap.get(key).getSelectedItem();
            sizesHashMap.put(key, size);
        }

        return sizesHashMap;
    }

    private HashMap<String, Integer> getInitialSizes() {
        ArrayList<String> keys = KeysArrayListGenerator.getSizesKeys();
        HashMap<String, Integer> sizesHashMap = new HashMap<>();

        for (String key : keys) {
            int size = 3;
            sizesHashMap.put(key, size);
        }

        return sizesHashMap;
    }
}
