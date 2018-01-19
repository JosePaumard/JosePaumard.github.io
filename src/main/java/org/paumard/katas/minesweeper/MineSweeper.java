package org.paumard.katas.minesweeper;

import java.util.Iterator;
import java.util.function.Predicate;

public class MineSweeper {

    private InputGrid inputGrid;

    public void init(String inputField) {
        String[] lines = inputField.split("\n");
        String[] firstLineSplit = lines[0].split(" ");
        int numberOfLines = Integer.parseInt(firstLineSplit[0].trim());
        int numberOfColumns = Integer.parseInt(firstLineSplit[1].trim());
        inputGrid = new InputGrid(numberOfLines, numberOfColumns, lines[1]);
    }

    public String produceHintField() {
        ResultGrid resultGrid = inputGrid.createEmptyResult();
        for (GridPosition position: inputGrid) {
            if (inputGrid.containsAMineAt(position)) {
                resultGrid.setAMineAt(position);
                resultGrid.updateNeighborhood(position);
            }
        }
        return resultGrid.createFinalResult();
    }

    private static class ResultGrid {

        private final char[] result;

        public ResultGrid(int numberOfColumns) {
            this.result = new char[numberOfColumns];
            for (int index = 0 ; index < numberOfColumns ; index++) {
                result[index] = '0';
            }
        }

        public void setAMineAt(GridPosition position) {
            this.result[position.getColumn()] = '*';
        }

        public void updateNeighborhood(GridPosition position) {
            if (previousIndexInBounds(position)) {
                updateNeighborhoodForPreviousIndex(position);
            }
            if (nextIndexInBounds(position)) {
                updateNeighborhoodForNextIndex(position);
            }
        }

        private boolean nextIndexInBounds(GridPosition position) {
            return isInBounds(position.getColumn() + 1);
        }

        private boolean previousIndexInBounds(GridPosition position) {
            return isInBounds(position.getColumn() - 1);
        }

        private boolean isInBounds(int positionIndex) {
            return positionIndex >= 0 && positionIndex < this.result.length;
        }

        public String createFinalResult() {
            return new String(result);
        }

        private void updateNeighborhoodForNextIndex(GridPosition position) {
            if (result[position.getColumn() + 1] != '*') {
                result[position.getColumn() + 1]++;
            }
        }

        private void updateNeighborhoodForPreviousIndex(GridPosition position) {
            if (result[position.getColumn() - 1] != '*') {
                result[position.getColumn() - 1]++;
            }
        }
    }

    private static class InputGrid implements Iterable<GridPosition> {

        private final int numberOfLines;
        private final int numberOfColumns;
        private final String line;

        public InputGrid(int numberOfLines, int numberOfColumns, String line) {

            this.numberOfLines = numberOfLines;
            this.numberOfColumns = numberOfColumns;
            this.line = line;
        }

        @Override
        public Iterator<GridPosition> iterator() {
            return new Iterator<GridPosition>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < line.length();
                }

                @Override
                public GridPosition next() {
                    GridPosition gridPosition = new GridPosition(index);
                    index++;
                    return gridPosition;
                }
            };
        }

        public boolean containsAMineAt(GridPosition position) {
            return line.charAt(position.getColumn()) == '*';
        }

        public ResultGrid createEmptyResult() {
            return new ResultGrid(this.numberOfColumns);
        }
    }

    private static class GridPosition {
        private int index;

        public GridPosition(int index) {
            this.index = index;
        }

        public int getColumn() {
            return index;
        }
    }
}
