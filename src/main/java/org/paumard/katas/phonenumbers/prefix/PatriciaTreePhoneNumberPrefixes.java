package org.paumard.katas.phonenumbers.prefix;

import org.paumard.katas.phonenumbers.PhoneNumberPrefixes;

import java.util.HashMap;
import java.util.Map;

public class PatriciaTreePhoneNumberPrefixes implements PhoneNumberPrefixes {

    private Node rootNode = Node.createRootNode();

    @Override
    public boolean containsAKnownPrefix(String phoneNumber) {
        Node node = rootNode;
        for (char digit : phoneNumber.toCharArray()) {
            if (digit != ' ') {
                node = node.get(digit);
                if (node == null) {
                    return false;
                }
                if (node.isTerminal()) {
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isAPrefix(String phoneNumber) {
        Node node = rootNode;
        for (char digit : phoneNumber.toCharArray()) {
            if (digit != ' ') {
                node = node.get(digit);
                if (node == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void addPrefix(String phoneNumber) {
        Node node = rootNode;
        for (char digit : phoneNumber.toCharArray()) {
            if (digit != ' ') {
                node = node.add(digit);
            }
        }
        node.setTerminal(true);
    }

    private static class Node {

        private boolean terminal = false;
        private Map<Character, Node> map = new HashMap<>();

        public static Node createRootNode() {
            return new Node();
        }

        public Node add(char digit) {
            return map.computeIfAbsent(digit, d -> new Node());
        }

        public Node get(char digit) {
            return map.get(digit);
        }

        public void setTerminal(boolean terminal) {
            this.terminal = terminal;
        }

        public boolean isTerminal() {
            return this.terminal;
        }
    }
}
