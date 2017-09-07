package ru.javawebinar.webapp.model;

import sun.security.krb5.internal.crypto.CksumType;

/**
 * Created by shukur on 04/09/17.
 */
public class Contact {
    private final ContactType type;
    private final String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
