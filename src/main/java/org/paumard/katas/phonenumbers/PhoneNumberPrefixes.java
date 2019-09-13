package org.paumard.katas.phonenumbers;

import org.paumard.katas.phonenumbers.model.PhoneNumber;

public interface PhoneNumberPrefixes {

    boolean containsAKnownPrefix(String phoneNumber);

    boolean isAPrefix(String phoneNumber);

    void addPrefix(PhoneNumber phoneNumber);
}
