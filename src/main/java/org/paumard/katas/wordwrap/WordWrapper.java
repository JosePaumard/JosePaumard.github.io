package org.paumard.katas.wordwrap;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() <= numberOfColumns) {
            return line;
        } else {

            return
            Stream.iterate(line, remainingLine -> getRemainingLine(remainingLine, numberOfColumns))
                    .takeWhile(remainingLine -> remainingLine.length() > 0)
                    .map(remainingLine -> getNextSegment(remainingLine, numberOfColumns))
                    .collect(Collectors.joining("\n"));
        }
    }

    private String getRemainingLine(String remainingLine, int numberOfColumns) {
        int limit = getLimit(remainingLine, numberOfColumns);
        String nextPart = stringBefore(remainingLine, numberOfColumns);
        if (nextPart.contains(" ")) {
            remainingLine = remainingLine.substring(limit + 1);
        } else {
            remainingLine = stringAfter(remainingLine, numberOfColumns);
        }
        return remainingLine;
    }

    private String stringAfter(String remainingLine, int numberOfColumns) {
        return numberOfColumns <= remainingLine.length() ? remainingLine.substring(numberOfColumns) : "";
    }

    private String stringBefore(String remainingLine, int numberOfColumns) {
        return numberOfColumns <= remainingLine.length() ? remainingLine.substring(0, numberOfColumns) : remainingLine;
    }

    private String getNextSegment(String remainingLine, int numberOfColumns) {
        int limit = getLimit(remainingLine, numberOfColumns);
        String nextPart = stringBefore(remainingLine, numberOfColumns);
        if (nextPart.contains(" ")) {
            return nextPart.substring(0, limit);
        } else {
            return nextPart;
        }
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
}
