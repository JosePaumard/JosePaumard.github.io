package org.paumard.katas.phonenumbers.prefix;

public interface Node {

    Node add(char digit);

    Node get(char digit);

    void setTerminal(boolean terminal);

    boolean isTerminal();
}
