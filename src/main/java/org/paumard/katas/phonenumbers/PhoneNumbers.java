package org.paumard.katas.phonenumbers;

import org.paumard.katas.phonenumbers.model.PhoneNumber;
import org.paumard.katas.phonenumbers.prefix.PatriciaTreePhoneNumberPrefixes;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumbers {
    public boolean isConsistent(List<String> phoneNumbersList) {
        if (phoneNumbersList.size() == 1) {
            return true;
        }

        PhoneNumberPrefixes phoneNumberPrefixes = new PatriciaTreePhoneNumberPrefixes();

        List<PhoneNumber> phoneNumbers = phoneNumbersList.stream().map(PhoneNumber::new).collect(Collectors.toList());
        for (PhoneNumber phoneNumber : phoneNumbers) {
            if (phoneNumber.containsAPrefixFrom(phoneNumberPrefixes)) {
                return false;
            }
            if (phoneNumber.isAPrefixFrom(phoneNumberPrefixes)) {
                return false;
            }
            phoneNumberPrefixes.addPrefix(phoneNumber.getPhoneNumber());
        }
        return true;
    }

}
