package org.paumard.katas.phonenumbers.prefix;

import org.paumard.katas.phonenumbers.PhoneNumberPrefixes;
import org.paumard.katas.phonenumbers.prefix.node.ArrayNode;

public class PatriciaTreePhoneNumberPrefixes implements PhoneNumberPrefixes {

    private Node rootNode = new ArrayNode();

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
}
