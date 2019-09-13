package org.paumard.katas.phonenumbers.model;

import org.paumard.katas.phonenumbers.PhoneNumberPrefixes;

public class PhoneNumber {
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean containsAPrefixFrom(PhoneNumberPrefixes phoneNumberPrefixes) {
        return phoneNumberPrefixes.containsAKnownPrefix(this.phoneNumber);
    }

    public boolean isAPrefixFrom(PhoneNumberPrefixes phoneNumberPrefixes) {
        return phoneNumberPrefixes.isAPrefix(this.phoneNumber);
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
