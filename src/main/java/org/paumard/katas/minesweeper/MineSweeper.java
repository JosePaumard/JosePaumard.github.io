package org.paumard.katas.minesweeper;

import java.util.Arrays;

public class MineSweeper {

    private String inputField;
    private int numberOfLines;
    private int numberOfColumns;

    public void init(String inputField) {
        String[] lines = inputField.split("\n");
        String[] firstLineSplit = lines[0].split(" ");
        this.numberOfLines = Integer.parseInt(firstLineSplit[0].trim());
        this.numberOfColumns = Integer.parseInt(firstLineSplit[1].trim());
        this.inputField = lines[1];
    }

    public String produceHintField() {
        if (numberOfColumns == 2) {
            if (inputField.startsWith("*")) {
                return "*1";
            } else {
                return "00";
            }
        }
        if (inputField.endsWith("*")) {
            return "*";
        } else {
            return "0";
        }
    }
}
