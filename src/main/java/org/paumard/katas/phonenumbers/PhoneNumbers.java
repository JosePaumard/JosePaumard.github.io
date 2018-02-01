package org.paumard.katas.phonenumbers;

import java.util.List;

public class PhoneNumbers {

    public boolean checkForConsistency(List<String> phoneNumbers) {
        if (phoneNumbers.size() == 1) {
            return true;
        }
        String firstPhoneNumber = phoneNumbers.get(0);
        String secondPhoneNumber = phoneNumbers.get(1);
        return !secondPhoneNumber.startsWith(firstPhoneNumber) &&
               !firstPhoneNumber.startsWith(secondPhoneNumber);
    }
}
