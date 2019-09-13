package org.paumard.katas.phonenumbers.prefix;

import org.paumard.katas.phonenumbers.PhoneNumberPrefixes;
import org.paumard.katas.phonenumbers.model.PhoneNumber;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InefficientPhoneNumberPrefixes implements PhoneNumberPrefixes {
    private Set<String> phoneNumberSet = new HashSet<>();

    private Stream<String> streamOfPrefixes(String string) {
        return IntStream.rangeClosed(1, string.length()).mapToObj(index -> string.substring(0, index));
    }

    @Override
    public boolean containsAKnownPrefix(String phoneNumber) {
        return streamOfPrefixes(phoneNumber).anyMatch(phoneNumberSet::contains);
    }

    @Override
    public boolean isAPrefix(String phoneNumber) {
        return phoneNumberSet.stream()
                        .flatMap(this::streamOfPrefixes)
                        .anyMatch(phoneNumber::equals);
    }

    @Override
    public void addPrefix(String phoneNumber) {
        phoneNumberSet.add(phoneNumber);
    }
}
