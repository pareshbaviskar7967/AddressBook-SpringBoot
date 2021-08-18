package com.example.addressbook_springboot.exceptions;

public class AddressBookException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AddressBookException(String message) {
        super(message);
    }
}
