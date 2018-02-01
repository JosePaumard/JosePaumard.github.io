package org.paumard.katas.phonenumbers;

import java.util.List;

public class PhoneNumbers {

    public boolean checkForConsistency(List<String> phoneNumbers) {
        if (phoneNumbers.size() == 1) {
            return true;
        }

        String prefix = phoneNumbers.get(0);
        for (int index = 1; index < phoneNumbers.size(); index++) {
            String phoneNumber = phoneNumbers.get(index);
            if (phoneNumber.startsWith(prefix)) {
                return false;
            } else if (prefix.startsWith(phoneNumber)) {
                return false;
            }
        }
        return true;
    }
}
