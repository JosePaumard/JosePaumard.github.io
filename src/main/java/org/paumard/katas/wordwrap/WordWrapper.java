package org.paumard.katas.wordwrap;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() < numberOfColumns) {
            return line;
        }
        int index = line.indexOf(" ");
        String firstLine = line.substring(0, index);
        String secondLine = line.substring(index + 1);
        return Stream.of(firstLine, secondLine).collect(Collectors.joining("\n"));
    }
}
