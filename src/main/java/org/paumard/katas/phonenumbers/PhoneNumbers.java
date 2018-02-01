package org.paumard.katas.phonenumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {
        if (phoneNumbersList.size() == 1) {
            return true;
        }

        Set<String> phoneNumberSet = new HashSet<>();
        for (String phoneNumber : phoneNumbersList) {
            if (!phoneNumberSet.add(phoneNumber)) {
                return false;
            }
        }
        return true;
    }
}
