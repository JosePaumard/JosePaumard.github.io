package org.paumard.katas.phonenumbers.prefix.node;

import org.paumard.katas.phonenumbers.prefix.Node;

import java.util.HashMap;
import java.util.Map;

public class HashMapNode implements Node {

    private boolean terminal = false;
    private Map<Character, HashMapNode> map = new HashMap<>();

    @Override
    public HashMapNode add(char digit) {
        return map.computeIfAbsent(digit, d -> new HashMapNode());
    }

    @Override
    public HashMapNode get(char digit) {
        return map.get(digit);
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
