package com.objectoriented;

import java.io.IOException;

public interface AddressBookInterface {
    void addNewPesonInto_AddressBook(String firstName,String lastName,String state, String city, String address, int zipCode, int phoneNumber) throws IOException;
    void printAllEntriZs();
}

