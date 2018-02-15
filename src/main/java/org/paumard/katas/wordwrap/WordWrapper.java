package org.paumard.katas.wordwrap;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordWrapper {

    public String wrap(int numberOfColumns, String lineToBeWarped) {

        Line line = Line.of(lineToBeWarped, numberOfColumns);

        return
                Stream.iterate(line, Line::getRemainingLine)
                        .takeWhile(Line::isNotEmpty)
                        .map(Line::getNextSegment)
                        .collect(Collectors.joining("\n"));

    }

    private interface Line {
        Line getRemainingLine();
        boolean isNotEmpty();
        String getNextSegment();

        static Line of (String lineToBeWarped, int numberOfColumns) {
            return new LineWithSpace(lineToBeWarped, numberOfColumns);
        }

    }

    private static class LineWithSpace implements Line {

        private final String lineToBeWarped;
        private final int numberOfColumns;
        private final String nextPart;
        private final int limit;
        private final boolean nextPartContainsSpace;

        private LineWithSpace(String lineToBeWarped, int numberOfColumns) {

            this.lineToBeWarped = lineToBeWarped;
            this.numberOfColumns = numberOfColumns;
            this.nextPart = stringBefore(lineToBeWarped, numberOfColumns);
            this.nextPartContainsSpace = nextPart.contains(" ");
            if (nextPartContainsSpace) {
                this.limit = nextPart.lastIndexOf(' ');
            } else {
                this.limit = numberOfColumns;
            }
        }


        private String stringAfter(String remainingLine, int numberOfColumns) {
            return numberOfColumns <= remainingLine.length() ? remainingLine.substring(numberOfColumns) : "";
        }

        private String stringBefore(String remainingLine, int numberOfColumns) {
            return numberOfColumns <= remainingLine.length() ? remainingLine.substring(0, numberOfColumns) : remainingLine;
        }

        @Override
        public Line getRemainingLine() {
            if (nextPartContainsSpace) {
                return new LineWithSpace(lineToBeWarped.substring(limit + 1), numberOfColumns);
            } else {
                return new LineWithSpace(stringAfter(lineToBeWarped, numberOfColumns), numberOfColumns);
            }
        }

        public boolean isNotEmpty() {
            return this.lineToBeWarped.length() > 0;
        }

        @Override
        public String getNextSegment() {
            if (nextPartContainsSpace) {
                return nextPart.substring(0, limit);
            } else {
                return nextPart;
            }
        }
    }
}
