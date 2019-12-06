package com.objectoriented;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();
    public AddressBookTest() throws FileNotFoundException {
    }
    @Test
    public void writeAddressBookPersonDetails_IntoJson() throws IOException {
        addressBook.addNewPesonInto_AddressBook("prashant", "Patil", "Maharashtra", "Thane", "Thane", "11212", "88888888");
    }
    @Test
    public void printAllEntries(){
        addressBook.printAllEntriZs();
    }
    @Test
    public void  deletePerson() throws IOException {
        addressBook.deletePerson("vijay");
    }
    @Test
    public void editpersonDetails() throws IOException {
        addressBook.editPersonDetails(1,"city","jaipur");
    }

    @Test
    public void sortRecordsByName() throws IOException {
        addressBook.sortRecordByFirstName();
    }
}


