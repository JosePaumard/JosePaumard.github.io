package org.paumard.katas.minesweeper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MineSweeper {

    private char[][] inputField;
    private int numberOfLines;
    private int numberOfColumns;

    public void init(String inputField) {
        String[] lines = inputField.split("\n");
        String[] firstLineSplit = lines[0].split(" ");
        this.numberOfLines = Integer.parseInt(firstLineSplit[0].trim());
        this.numberOfColumns = Integer.parseInt(firstLineSplit[1].trim());
        int firstLineOfMineField = 1;
        this.inputField = new char[numberOfLines][];
        for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
            this.inputField[lineIndex] = lines[lineIndex + firstLineOfMineField].trim().toCharArray();
        }
    }

    public String produceHintField() {

        char[][] result = createEmptyResult();
        for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                if (containsAMineAtIndex(inputField, lineIndex, columnIndex)) {
                    setAMineAtIndex(result, lineIndex, columnIndex);
                    updateNeighborhood(result, lineIndex, columnIndex);
                }
            }
        }

        return createFinalResult(result);
    }

    private String createFinalResult(char[][] mineField) {
        return Arrays.stream(mineField).map(String::new).collect(Collectors.joining("\r\n"));
    }

    private void updateNeighborhood(char[][] mineField, int lineIndex, int columnIndex) {

        for (int deltaLine = -1; deltaLine <= 1; deltaLine++) {
            for (int deltaColumn = -1; deltaColumn <= 1; deltaColumn++) {
                if (lineIndex + deltaLine >= 0 && lineIndex + deltaLine < numberOfLines &&
                        columnIndex + deltaColumn >= 0 && columnIndex + deltaColumn < numberOfColumns) {
                    if (mineField[lineIndex + deltaLine][columnIndex + deltaColumn] != '*') {
                        mineField[lineIndex + deltaLine][columnIndex + deltaColumn]++;
                    }
                }
            }
        }
    }

    private void setAMineAtIndex(char[][] mineField, int lineIndex, int columnIndex) {
        mineField[lineIndex][columnIndex] = '*';
    }

    private boolean containsAMineAtIndex(char[][] mineField, int lineIndex, int columnIndex) {
        return mineField[lineIndex][columnIndex] == '*';
    }

    private char[][] createEmptyResult() {
        char[][] result = new char[numberOfLines][numberOfColumns];
        for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
            result[lineIndex] = new char[numberOfColumns];
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                result[lineIndex][columnIndex] = '0';
            }

        }
        return result;
    }
}
