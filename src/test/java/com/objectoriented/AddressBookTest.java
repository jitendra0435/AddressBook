package com.objectoriented;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();
    public AddressBookTest() throws FileNotFoundException {
    }
    @Test
    public void WriteAddressBookPersonDetails_IntoJson() throws IOException {
        addressBook.addNewPesonInto_AddressBook("jitendrAB", "Patil","Maharashtra", "Thane", "Thane", 11212, 88888888);
    }
    @Test
    public void PrintAllEntries(){
        addressBook.printAllEntriZs();
    }
}


