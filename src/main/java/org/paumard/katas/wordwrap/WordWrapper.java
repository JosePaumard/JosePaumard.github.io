package org.paumard.katas.wordwrap;

public class WordWrapper {

    public String wrap(int numberOfColumns, String line) {
        if (line.length() <= numberOfColumns) {
            return line;
        } else {
            String result = "";
            String remainingLine;
            String nextPart = line.substring(0, numberOfColumns);
            if (nextPart.contains(" ")) {
                int limit = nextPart.lastIndexOf(' ');
                nextPart = line.substring(0, limit);
                remainingLine = line.substring(limit + 1);
            } else {
                remainingLine = line.substring(numberOfColumns);
            }
            result = nextPart;

            while (remainingLine.length() >  numberOfColumns) {

                nextPart = remainingLine.substring(0, numberOfColumns);
                if (nextPart.contains(" ")) {
                    int limit = nextPart.lastIndexOf(' ');
                    result += "\n" + nextPart.substring(0, limit);
                    remainingLine = remainingLine.substring(limit + 1);
                } else {
                    result += "\n" + nextPart;
                    remainingLine = remainingLine.substring(numberOfColumns);
                }
            }
            return result + "\n" + remainingLine;
        }
    }
}
