package org.paumard.katas.wordwrap;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() <= numberOfColumns) {
            return line;
        } else {
            String firstPart = line.substring(0, numberOfColumns);
            if (firstPart.contains(" ")) {
                int indexOfSpace = firstPart.lastIndexOf(' ');
                firstPart = line.substring(0, indexOfSpace);
                String secondPart = wrap(indexOfSpace + 1, line.substring(indexOfSpace + 1));
                return firstPart + "\n" + secondPart;
            } else {
                String secondPart = wrap(numberOfColumns, line.substring(numberOfColumns));
                return firstPart + "\n" + secondPart;
            }
        }
    }
}
