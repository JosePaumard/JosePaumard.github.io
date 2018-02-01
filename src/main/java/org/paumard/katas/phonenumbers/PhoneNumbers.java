package org.paumard.katas.phonenumbers;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumbers {

    public boolean checkForConsistency(List<String> phoneNumbers) {
        if (phoneNumbers.size() == 1) {
            return true;
        }

        List<String> seenPhoneNumbers = new ArrayList<>();
        seenPhoneNumbers.add(phoneNumbers.get(0));
        for (int index = 1; index < phoneNumbers.size(); index++) {
            String phoneNumber = phoneNumbers.get(index);
            for (String seenPhoneNumber : seenPhoneNumbers) {
                if (phoneNumber.startsWith(seenPhoneNumber) || seenPhoneNumber.startsWith(phoneNumber)) {
                    return false;
                }
            }
            seenPhoneNumbers.add(phoneNumber);
        }
        return true;
    }
}
