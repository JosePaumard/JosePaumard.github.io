package org.paumard.katas.wordwrap;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() <= numberOfColumns) {
            return line;
        } else {
            String firstPart = line.substring(0, numberOfColumns);
            String secondPart = wrap(numberOfColumns, line.substring(numberOfColumns));
            return firstPart + "\n" + secondPart;
        }
    }
}
