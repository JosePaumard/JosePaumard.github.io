package org.paumard.katas.phonenumbers;

public interface PhoneNumberPrefixes {

    boolean containsAKnownPrefix(String phoneNumber);

    boolean isAPrefix(String phoneNumber);

    void addPrefix(String phoneNumber);
}
