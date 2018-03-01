package org.paumard.katas.phonenumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {

        PhoneNumberPrefixes phoneNumberPrefixes = new PhoneNumberPrefixes();
        for (String phoneNumber : phoneNumbersList) {
            if (phoneNumberPrefixes.containsAKnownPrefix(phoneNumber)) {
                return false;
            }
            phoneNumberPrefixes.addToPrefixSet(phoneNumber);
        }
        return true;
    }

    private class PhoneNumberPrefixes {
        private Set<String> phoneNumberSet = new HashSet<>();

        private Stream<String> streamOfPrefixes(String string) {
            return IntStream.rangeClosed(1, string.length()).mapToObj(index -> string.substring(0, index));
        }

        boolean containsAKnownPrefix(String phoneNumber) {
            return streamOfPrefixes(phoneNumber).anyMatch(phoneNumberSet::contains);
        }

        void addToPrefixSet(String phoneNumber) {
            phoneNumberSet.add(phoneNumber);
        }
    }
}
