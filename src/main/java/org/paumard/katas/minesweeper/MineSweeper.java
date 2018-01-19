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
        ResultGrid resultGrid = createEmptyResult();
        for (GridPosition position: inputGrid) {
            if (inutGrid.containsAMineAt(position)) {
                resultGrid.setAMineAt(position);
                resultGrid.updateNeighborhood(position);
            }
        }
        return createFinalResult(result);
    }

    private String createFinalResult(char[] result) {
        return new String(result);
    }

    private void updateNeighborhood(char[] result, int index) {
        if (previousIndexInBounds(index)) {
            updateNeighborhoodForPreviousIndex(result, index);
        }
        if (nextIndexInBounds(index)) {
            updateNeighborhoodForNextIndex(result, index);
        }
    }

    private void updateNeighborhoodForNextIndex(char[] result, int index) {
        if (result[index + 1] != '*') {
            result[index + 1]++;
        }
    }

    private void updateNeighborhoodForPreviousIndex(char[] result, int index) {
        if (result[index - 1] != '*') {
            result[index - 1]++;
        }
    }

    private boolean nextIndexInBounds(int index) {
        return index + 1 < inputField.length();
    }

    private boolean previousIndexInBounds(int index) {
        return index - 1 >= 0;
    }

    private void setAMineAtIndex(char[] result, int index) {
        result[index] = '*';
    }

    private boolean containsAMineAtIndex(int index) {
        return inputField.charAt(index) == '*';
    }

    private char[] createEmptyResult() {
        char[] result = new char[inputField.length()];
        for (int index = 0 ; index < inputField.length() ; index++) {
            result[index] = '0';
        }
        return result;
    }
}
