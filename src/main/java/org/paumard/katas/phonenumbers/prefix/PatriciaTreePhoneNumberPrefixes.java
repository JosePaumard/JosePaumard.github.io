package org.paumard.katas.phonenumbers.prefix;

import org.paumard.katas.phonenumbers.PhoneNumberPrefixes;

import java.util.HashMap;
import java.util.Map;

public class PatriciaTreePhoneNumberPrefixes implements PhoneNumberPrefixes {

    private Node rootNode = Node.createRootNode();

    @Override
    public boolean containsAKnownPrefix(String phoneNumber) {
        return false;
    }

    @Override
    public boolean isAPrefix(String phoneNumber) {
        return false;
    }

    @Override
    public void addPrefix(String phoneNumber) {
    }

    private static class Node {
        public static Node createRootNode() {
            return null;
        }
    }
}
