package org.paumard.katas.wordwrap;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() <= numberOfColumns) {
            return line;
        } else {
            String result = line.substring(0, numberOfColumns);
            String nextPart;
            if (result.contains(" ")) {
                int limit = result.indexOf(' ');
                result = line.substring(0, limit);
                nextPart = line.substring(limit + 1);
            } else {
                nextPart = line.substring(numberOfColumns);
            }

            while (nextPart.length() >  numberOfColumns) {
                result += "\n" + nextPart.substring(0, numberOfColumns);
                nextPart = nextPart.substring(numberOfColumns);
            }
            return result + "\n" + nextPart;
        }
    }
}
