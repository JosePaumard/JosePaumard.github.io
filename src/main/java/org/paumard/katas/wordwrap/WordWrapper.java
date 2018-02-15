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
            } else if (!lineToBeWarped.contains(" ")) {
                return Line.longLineWithNoSpace(lineToBeWarped, numberOfColumns);
            } else if (lineToBeWarped.indexOf(' ') > numberOfColumns) {
                return Line.longLineWithNoSpace(lineToBeWarped, numberOfColumns);
            } else {
                return Line.longLineWithSpace(lineToBeWarped, numberOfColumns);
            }
        }

        static Line longLineWithSpace(String lineToBeWarped, int numberOfColumns) {
            return new LongLineWithSpace(lineToBeWarped, numberOfColumns);
        }

        static Line longLineWithNoSpace(String lineToBeWarped, int numberOfColumns) {
            return new LongLineWithNoSpace(lineToBeWarped, numberOfColumns);
        }

        static Line shortLine(String lineToBeWarped) {
            return new ShortLine(lineToBeWarped);
        }

        static Line empty() {
            return new EmptyLine();
        }
    }

    private static class LongLineWithNoSpace implements Line {
        private final String line;
        private final int numberOfColumns;

        public LongLineWithNoSpace(String line, int numberOfColumns) {
            this.line = line;
            this.numberOfColumns = numberOfColumns;
        }

        public Line getRemainingLine() {
            return Line.of(line.substring(numberOfColumns), numberOfColumns);
        }

        public boolean isNotEmpty() {
            return true;
        }

        public String getNextSegment() {
            return line.substring(0, numberOfColumns);
        }
    }

    private static class ShortLine implements Line {
        private String line;

        public ShortLine(String line) {
            this.line = line;
        }

        public Line getRemainingLine() {
            return Line.empty();
        }

        public boolean isNotEmpty() {
            return true;
        }

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

    private static class LongLineWithSpace implements Line {

        private final int numberOfColumns;
        private final String segment;
        private final String remainingLine;

        private LongLineWithSpace(String lineToBeWarped, int numberOfColumns) {

            this.numberOfColumns = numberOfColumns;
            String nextPart = lineToBeWarped.substring(0, numberOfColumns);
            int limit = nextPart.lastIndexOf(' ');
            this.segment = nextPart.substring(0, limit);
            this.remainingLine = lineToBeWarped.substring(limit + 1);
        }

        @Override
        public Line getRemainingLine() {
            return Line.of(remainingLine, numberOfColumns);
        }

        public boolean isNotEmpty() {
            return true;
        }

        @Override
        public String getNextSegment() {
            return segment;
        }
    }
}
