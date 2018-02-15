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
            if (lineToBeWarped.isEmpty()) {
                return Line.empty();
            } else if (lineToBeWarped.length() <= numberOfColumns) {
                return Line.shortLine(lineToBeWarped);
            }
            return new LineWithSpace(lineToBeWarped, numberOfColumns);
        }

        static Line shortLine(String lineToBeWarped) {
            return new ShortLine(lineToBeWarped);
        }

        static Line empty() {
            return new EmptyLine();
        }
    }

    private static class ShortLine implements Line {
        private String line;

        public ShortLine(String line) {
            this.line = line;
        }

        @Override
        public Line getRemainingLine() {
            return Line.empty();
        }

        @Override
        public boolean isNotEmpty() {
            return true;
        }

        @Override
        public String getNextSegment() {
            return line;
        }
    }

    private static class EmptyLine implements Line {

        public Line getRemainingLine() {
            return this;
        }

        public boolean isNotEmpty() {
            return false;
        }

        public String getNextSegment() {
            return "";
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
