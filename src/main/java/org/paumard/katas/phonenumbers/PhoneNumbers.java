package org.paumard.katas.phonenumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {
        if (phoneNumbersList.size() == 1) {
            return true;
        }
        PhoneNumberPrefixes phoneNumberPrefixes = new PhoneNumberPrefixes();
        List<PhoneNumber> phoneNumbers = phoneNumbersList.stream().map(PhoneNumber::new).collect(Collectors.toList());
        for (PhoneNumber phoneNumber : phoneNumbers) {
            if (phoneNumber.containsAPrefixFrom(phoneNumberPrefixes)) {
                return false;
            }
            if (phoneNumber.isAPrefixFrom(phoneNumberPrefixes)) {
                return false;
            }
            phoneNumberPrefixes.addPrefix(phoneNumber);
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

        void addPrefix(PhoneNumber phoneNumber) {
            phoneNumberSet.add(phoneNumber.getPhoneNumber());
        }

        private boolean isAPrefix(String phoneNumber) {
            return phoneNumberSet.stream()
                            .flatMap(this::streamOfPrefixes)
                            .anyMatch(phoneNumber::equals);
        }
    }

    private class PhoneNumber {
        private String phoneNumber;

        public PhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public boolean containsAPrefixFrom(PhoneNumberPrefixes phoneNumberPrefixes) {
            return false;
        }

        public boolean isAPrefixFrom(PhoneNumberPrefixes phoneNumberPrefixes) {
            return false;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }
    }
}
