package org.paumard.katas.phonenumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {

        Set<String> phoneNumberSet = new HashSet<>();
        for (String phoneNumber : phoneNumbersList) {
            if (
            IntStream.rangeClosed(1, phoneNumber.length())
                    .mapToObj(index -> phoneNumber.substring(0, index))
                    .anyMatch(phoneNumberSet::contains)
                    ) {
                return false;
            }
            phoneNumberSet.add(phoneNumber);
        }
        return true;
    }
}
