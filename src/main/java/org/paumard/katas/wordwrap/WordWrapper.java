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
            String nextPart = remainingLine;
            nextPart = remainingLine.substring(0, numberOfColumns);
            if (nextPart.contains(" ")) {
                int limit = nextPart.lastIndexOf(' ');
                lines.add(nextPart.substring(0, limit));
                remainingLine = remainingLine.substring(limit + 1);
            } else {
                lines.add(nextPart);
                remainingLine = remainingLine.substring(numberOfColumns);
            }

            while (remainingLine.length() >  numberOfColumns) {

                nextPart = remainingLine.substring(0, numberOfColumns);
                if (nextPart.contains(" ")) {
                    int limit = nextPart.lastIndexOf(' ');
                    lines.add(nextPart.substring(0, limit));
                    remainingLine = remainingLine.substring(limit + 1);
                } else {
                    lines.add(nextPart);
                    remainingLine = remainingLine.substring(numberOfColumns);
                }
            }
            lines.add(remainingLine);
            return lines.stream().collect(Collectors.joining("\n"));
        }
    }
}
