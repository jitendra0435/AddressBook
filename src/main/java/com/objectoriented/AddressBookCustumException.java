package com.objectoriented;

public class AddressBookCustumException extends Exception {
    public AddressBookCustumException(ExceptionType type) {
        this.type=type;
    }
    public ExceptionType type;
    public enum ExceptionType {FILE_ALREADY_PRESENT}
}
