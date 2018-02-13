package org.paumard.katas.wordwrap;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordWrapper {

    public String wrap(int numberOfColumns, String lineToBeWarped) {

        Line line = new Line(lineToBeWarped, numberOfColumns);

        return
                Stream.iterate(line, Line::getRemainingLine)
                        .takeWhile(Line::isNotEmpty)
                        .map(Line::getNextSegment)
                        .collect(Collectors.joining("\n"));

    }

    private class Line {

        private final String lineToBeWarped;
        private final int numberOfColumns;

        public Line(String lineToBeWarped, int numberOfColumns) {

            this.lineToBeWarped = lineToBeWarped;
            this.numberOfColumns = numberOfColumns;
        }


        private String stringAfter(String remainingLine, int numberOfColumns) {
            return numberOfColumns <= remainingLine.length() ? remainingLine.substring(numberOfColumns) : "";
        }

        private String stringBefore(String remainingLine, int numberOfColumns) {
            return numberOfColumns <= remainingLine.length() ? remainingLine.substring(0, numberOfColumns) : remainingLine;
        }

        private int getLimit(String remainingLine, int numberOfColumns) {
            String nextPart =
                    stringBefore(remainingLine, numberOfColumns);
            if (nextPart.contains(" ")) {
                return nextPart.lastIndexOf(' ');
            } else {
                return numberOfColumns;
            }
        }

        public Line getRemainingLine() {
            int limit = getLimit(lineToBeWarped, numberOfColumns);
            String nextPart = stringBefore(lineToBeWarped, numberOfColumns);
            if (nextPart.contains(" ")) {
                return new Line(lineToBeWarped.substring(limit + 1), numberOfColumns);
            } else {
                return new Line(stringAfter(lineToBeWarped, numberOfColumns), numberOfColumns);
            }
        }

        public boolean isNotEmpty() {
            return this.lineToBeWarped.length() > 0;
        }

        public String getNextSegment() {
            int limit = getLimit(lineToBeWarped, numberOfColumns);
            String nextPart = stringBefore(lineToBeWarped, numberOfColumns);
            if (nextPart.contains(" ")) {
                return nextPart.substring(0, limit);
            } else {
                return nextPart;
            }
        }
    }
}
