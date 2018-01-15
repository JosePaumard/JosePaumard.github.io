package org.paumard.katas.minesweeper;

public class MineSweeper {

    private String inputField;

    public void init(String inputField) {
        this.inputField = inputField;
    }

    public String produceHintField() {
        if (inputField.endsWith("*")) {
            return "*";
        } else {
            return "0";
        }
    }
}
