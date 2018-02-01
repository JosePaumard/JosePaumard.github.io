package org.paumard.katas.phonenumbers;

import java.util.List;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {
        if (phoneNumbersList.size() == 1) {
            return true;
        }

        return !phoneNumbersList.get(0).equals(phoneNumbersList.get(1));
    }
}
