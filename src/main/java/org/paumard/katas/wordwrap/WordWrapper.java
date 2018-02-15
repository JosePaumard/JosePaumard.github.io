package org.paumard.katas.wordwrap;


import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordWrapper {

    public String wrap(int numberOfColumns, String lineToBeWrapped) {

        Line line = Line.of(lineToBeWrapped, numberOfColumns);

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

        static Line of (String lineToBeWrapped, int numberOfColumns) {

            LineFactory lineFactory = LineFactory.of(lineToBeWrapped, numberOfColumns);
            return lineFactory.wrapLine(lineToBeWrapped, numberOfColumns);
        }

        static Line longLineWithSpace(String lineToBeWrapped, int numberOfColumns) {
            return new LongLineWithSpace(lineToBeWrapped, numberOfColumns);
        }

        static Line longLineWithNoSpace(String lineToBeWrapped, int numberOfColumns) {
            return new LongLineWithNoSpace(lineToBeWrapped, numberOfColumns);
        }

        static Line shortLine(String lineToBeWrapped) {
            return new ShortLine(lineToBeWrapped);
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

        private LongLineWithSpace(String line, int numberOfColumns) {

            this.numberOfColumns = numberOfColumns;
            String nextPart = line.substring(0, numberOfColumns);
            int limit = nextPart.lastIndexOf(' ');
            this.segment = nextPart.substring(0, limit);
            this.remainingLine = line.substring(limit + 1);
        }

        public Line getRemainingLine() {
            return Line.of(remainingLine, numberOfColumns);
        }

        public boolean isNotEmpty() {
            return true;
        }

        public String getNextSegment() {
            return segment;
        }
    }

    private enum LineFactory {
        EMPTY_LINE_FACTORY(
                (line, numberOfColumns) -> line.isEmpty(),
                (line, numberOfColumns) -> Line.empty()
        ),
        SHORT_LINE_FACTORY(
                (line, numberOfColumns) -> line.length() <= numberOfColumns,
                (line, numberOfColumns) -> Line.shortLine(line)
        ),
        LONG_LINE_WITH_NO_SPACE(
                (line, numberOfColumns) -> !line.contains(" ") || line.indexOf(' ') > numberOfColumns,
                Line::longLineWithNoSpace
        ),
        LONG_LINE_WITH_SPACE(
                (line, numberOfColumns) -> line.length() > numberOfColumns && line.indexOf(' ') <= numberOfColumns,
                Line::longLineWithSpace
        )
        ;

        private BiPredicate<String, Integer> selector;
        private BiFunction<String, Integer, Line> lineFactory;

        LineFactory(BiPredicate<String, Integer> selector, BiFunction<String, Integer, Line> lineFactory) {
            this.selector = selector;
            this.lineFactory = lineFactory;
        }

        public static LineFactory of(String line, int numberOfColumns) {
            return Arrays.stream(values())
                    .filter(factory -> factory.selector.test(line, numberOfColumns))
                    .findFirst().get();
        }

        public Line wrapLine(String line, int numberOfColumns) {
            return lineFactory.apply(line, numberOfColumns);
        }
    }
}
