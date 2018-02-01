package org.paumard.katas.phonenumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {

        Set<String> phoneNumberSet = new HashSet<>();
        for (String phoneNumber : phoneNumbersList) {
            if (!phoneNumberSet.add(phoneNumber.substring(0, 1))) {
                return false;
            }
        }
        return true;
    }
}
