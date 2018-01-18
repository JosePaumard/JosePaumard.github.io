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
        char[] result = new char[inputField.length()];
        for (int index = 0 ; index < inputField.length() ; index++) {
            result[index] = '0';
        }
        for (int index = 0 ; index < inputField.length() ; index++) {
            if (inputField.charAt(index) == '*') {
                result[index] = '*';
                if (index - 1 >= 0) {
                    if (result[index - 1] != '*') {
                        result[index - 1]++;
                    }
                }
                if (index + 1 < inputField.length()) {
                    if (result[index + 1] != '*') {
                        result[index + 1]++;
                    }
                }
            }
        }
        return new String(result);
    }
}
