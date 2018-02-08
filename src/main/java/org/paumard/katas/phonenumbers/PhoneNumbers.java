package org.paumard.katas.phonenumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {

        Set<String> phoneNumberSet = new HashSet<>();
        for (String phoneNumber : phoneNumbersList) {
            String phoneNumberPrefix = phoneNumber.substring(0, 1);
            if (phoneNumberSet.contains(phoneNumberPrefix)) {
                return false;
            }
            phoneNumberSet.add(phoneNumberPrefix);
        }
        return true;
    }
}
