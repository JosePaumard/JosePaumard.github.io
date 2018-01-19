package org.paumard.katas.minesweeper;

import java.util.Arrays;
import java.util.Iterator;

public class MineSweeper {

    private String inputField;
    private int numberOfLines;
    private int numberOfColumns;
    private InputGrid inputGrid;

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
            if (inputGrid.containsAMineAt(position)) {
                resultGrid.setAMineAt(position);
                resultGrid.updateNeighborhood(position);
            }
        }
        return resultGrid.createFinalResult();
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

    private ResultGrid createEmptyResult() {
        char[] result = new char[inputField.length()];
        for (int index = 0 ; index < inputField.length() ; index++) {
            result[index] = '0';
        }
        return result;
    }

    private static class ResultGrid {
        public void setAMineAt(GridPosition position) {

        }

        public void updateNeighborhood(GridPosition position) {

        }

        public String createFinalResult() {
            return null;
        }
    }

    private static class InputGrid implements Iterable<GridPosition> {
        @Override
        public Iterator<GridPosition> iterator() {
            return null;
        }

        public boolean containsAMineAt(GridPosition position) {
            return false;
        }
    }

    private static class GridPosition {
    }
}
