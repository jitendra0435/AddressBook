package com.objectoriented;
import java.io.IOException;

public interface AddressBookInterface {
     void addNewPesonInto_AddressBook(String firstName,String lastName,String state, String city, String address, int zipCode, int phoneNumber) throws IOException;
     void printAllEntriZs();
     void deletePerson(String firstName) throws IOException;
     void editPersonDetails(int index,String property,String updatedValue) throws IOException;
}

