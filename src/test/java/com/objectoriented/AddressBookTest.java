package com.objectoriented;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();
    public AddressBookTest() throws FileNotFoundException {
    }
    @Test
    public void writeAddressBookPersonDetails_IntoJson() throws IOException {
        addressBook.addNewPesonInto_AddressBook("rahul", "Patil", "Maharashtra", "Thane", "Thane", "123789", "88888888");
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
    @Test
    public void sortRecordsByZipCode() throws IOException {
        addressBook.sortRecordByZipCode();
    }

    @Test
    public void createNewAddressBook() throws IOException{
        boolean created= false;
        try {
            created = addressBook.createAddressBook("newFile1");
            Assert.assertEquals(created,true);
        } catch (AddressBookCustumException e) {
            Assert.assertEquals(AddressBookCustumException.ExceptionType.FILE_ALREADY_PRESENT,e.type);
        }
    }
    @Test
    public void OpenExistingFile(){
        boolean open= false;
        try {
            open = addressBook.OpenExistingFile("newFile.json");
            Assert.assertEquals(open,true);
        } catch (AddressBookCustumException e) {
            Assert.assertEquals(AddressBookCustumException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }

    @Test
    public void saveAddressBook() throws IOException {
        addressBook.saveFile("addressBook.json");
    }
}


