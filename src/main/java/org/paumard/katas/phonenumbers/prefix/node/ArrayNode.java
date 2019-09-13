package org.paumard.katas.phonenumbers.prefix.node;

import org.paumard.katas.phonenumbers.prefix.Node;

public class ArrayNode implements Node {

    private Node[] nodes = new Node[10];
    private boolean terminal;

    @Override
    public Node add(char digit) {
        if (nodes[digit - '0'] == null) {
            nodes[digit - '0'] = new ArrayNode();
        }
        return nodes[digit - '0'];
    }

    @Override
    public Node get(char digit) {
        return nodes[digit - '0'];
    }

    @Override
    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    @Override
    public boolean isTerminal() {
        return this.terminal;
    }
}
