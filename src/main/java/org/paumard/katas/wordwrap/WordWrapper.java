package org.paumard.katas.wordwrap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() <= numberOfColumns) {
            return line;
        } else {
            List<String> lines = new ArrayList<>();
            String remainingLine = line;
            int limit = 0;
            String nextPart = remainingLine.substring(0, numberOfColumns);
            limit = getLimit(numberOfColumns, nextPart);
            String nextSegment = getNextSegment(nextPart, limit);
            lines.add(nextSegment);
            remainingLine = getRemainingLine(remainingLine, nextPart, numberOfColumns, limit);

            while (remainingLine.length() > numberOfColumns) {

                nextPart = remainingLine.substring(0, numberOfColumns);
                limit = getLimit(numberOfColumns, nextPart);
                nextSegment = getNextSegment(nextPart, limit);
                lines.add(nextSegment);
                remainingLine = getRemainingLine(remainingLine, nextPart, numberOfColumns, limit);
            }
            lines.add(remainingLine);
            return lines.stream().collect(Collectors.joining("\n"));
        }
    }

    private String getRemainingLine(String remainingLine, String nextPart, int numberOfColumns, int limit) {
        if (nextPart.contains(" ")) {
            remainingLine = remainingLine.substring(limit + 1);
        } else {
            remainingLine = remainingLine.substring(numberOfColumns);
        }
        return remainingLine;
    }

    private String getNextSegment(String nextPart, int limit) {
        if (nextPart.contains(" ")) {
            return nextPart.substring(0, limit);

        } else {
            return nextPart;
        }
    }

    private int getLimit(int numberOfColumns, String nextPart) {
        if (nextPart.contains(" ")) {
            return nextPart.lastIndexOf(' ');
        } else {
            return numberOfColumns;
        }
    }
}
