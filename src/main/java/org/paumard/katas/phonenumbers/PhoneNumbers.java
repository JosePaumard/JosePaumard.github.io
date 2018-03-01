package org.paumard.katas.phonenumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {

        Set<String> phoneNumberSet = new HashSet<>();
        for (String phoneNumber : phoneNumbersList) {
            if (containsAKnownPrefix(phoneNumberSet, phoneNumber)) {
                return false;
            }
            addToPrefixSet(phoneNumberSet, phoneNumber);
        }
        return true;
    }

    private boolean addToPrefixSet(Set<String> phoneNumberSet, String phoneNumber) {
        return phoneNumberSet.add(phoneNumber);
    }

    private boolean containsAKnownPrefix(Set<String> phoneNumberSet, String phoneNumber) {
        return streamOfPrefixes(phoneNumber).anyMatch(phoneNumberSet::contains);
    }

    static Stream<String> streamOfPrefixes(String string) {
        return IntStream.rangeClosed(1, string.length()).mapToObj(index -> string.substring(0, index));
    }
}
