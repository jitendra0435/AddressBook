package com.objectoriented;
import java.io.IOException;

public interface AddressBookInterface {
     void addNewPesonInto_AddressBook(String firstName,String lastName,String state, String city, String address, String zipCode, String phoneNumber) throws IOException;
     void printAllEntriZs();
     void deletePerson(String firstName) throws IOException;
     void editPersonDetails(int index,String firstName,String updatedValue) throws IOException;
     void sortRecordByFirstName() throws IOException;
     void sortRecordByZipCode() throws IOException;
     boolean createAddressBook(String fileName) throws IOException, AddressBookCustumException;
     boolean OpenExistingFile(String filename) throws AddressBookCustumException;
     boolean saveFile() throws IOException;
}

