package com.objectoriented;
import java.io.IOException;

public interface AddressBookInterface {
     boolean addNewPesonInto_AddressBook(String firstName, String lastName, String state, String city, String address, String zipCode, String phoneNumber) throws IOException;
     boolean printAllEntriZs();
     boolean deletePerson(String firstName) throws IOException;
     boolean editPersonDetails(int index, String firstName, String updatedValue) throws IOException;
     boolean sortRecordByFirstName() throws IOException;
     boolean sortRecordByZipCode() throws IOException;
     boolean createAddressBook(String fileName) throws IOException, AddressBookCustumException;
     boolean openExistingFile(String fileName) throws AddressBookCustumException;
}

