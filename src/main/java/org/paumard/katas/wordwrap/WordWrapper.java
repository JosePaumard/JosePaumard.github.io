package org.paumard.katas.wordwrap;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() <= numberOfColumns) {
            return line;
        } else {
            String result = line.substring(0, numberOfColumns);
            String nextPart = line.substring(numberOfColumns);
            if (nextPart.length() >  numberOfColumns) {
                result += "\n" + nextPart.substring(0, numberOfColumns);
                nextPart = nextPart.substring(numberOfColumns);
            }
            return result + "\n" + nextPart;
        }
    }
}
