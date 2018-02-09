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
            int limit = getLimit(remainingLine, numberOfColumns);
            String nextSegment = getNextSegment(remainingLine, numberOfColumns, limit);
            lines.add(nextSegment);
            remainingLine = getRemainingLine(remainingLine, numberOfColumns, limit);

            while (remainingLine.length() > numberOfColumns) {

                limit = getLimit(remainingLine, numberOfColumns);
                nextSegment = getNextSegment(remainingLine, numberOfColumns, limit);
                lines.add(nextSegment);
                remainingLine = getRemainingLine(remainingLine, numberOfColumns, limit);
            }
            lines.add(remainingLine);
            return lines.stream().collect(Collectors.joining("\n"));
        }
    }

    private String getRemainingLine(String remainingLine, int numberOfColumns, int limit) {
        String nextPart = remainingLine.substring(0, numberOfColumns);
        if (nextPart.contains(" ")) {
            remainingLine = remainingLine.substring(limit + 1);
        } else {
            remainingLine = remainingLine.substring(numberOfColumns);
        }
        return remainingLine;
    }

    private String getNextSegment(String remainingLine, int numberOfColumns, int limit) {
        String nextPart = remainingLine.substring(0, numberOfColumns);
        if (nextPart.contains(" ")) {
            return nextPart.substring(0, limit);

        } else {
            return nextPart;
        }
    }

    private int getLimit(String remainingLine, int numberOfColumns) {
        String nextPart = remainingLine.substring(0, numberOfColumns);
        if (nextPart.contains(" ")) {
            return nextPart.lastIndexOf(' ');
        } else {
            return numberOfColumns;
        }
    }
}
