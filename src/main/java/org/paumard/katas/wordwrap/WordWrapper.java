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
            String nextSegment;
            if (nextPart.contains(" ")) {
                nextSegment = nextPart.substring(0, limit);

            } else {
                nextSegment = nextPart;
            }
            lines.add(nextSegment);
            if (nextPart.contains(" ")) {
                remainingLine = remainingLine.substring(limit + 1);
            } else {
                remainingLine = remainingLine.substring(numberOfColumns);
            }

            while (remainingLine.length() > numberOfColumns) {

                nextPart = remainingLine.substring(0, numberOfColumns);
                limit = getLimit(numberOfColumns, nextPart);
                if (nextPart.contains(" ")) {
                    nextSegment = nextPart.substring(0, limit);
                } else {
                    nextSegment = nextPart;
                }
                lines.add(nextSegment);
                if (nextPart.contains(" ")) {
                    remainingLine = remainingLine.substring(limit + 1);
                } else {
                    remainingLine = remainingLine.substring(numberOfColumns);
                }
            }
            lines.add(remainingLine);
            return lines.stream().collect(Collectors.joining("\n"));
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
