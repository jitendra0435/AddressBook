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
        boolean flag=addressBook.addNewPesonInto_AddressBook("rahul", "Patil", "Maharashtra", "Thane", "Thane", "123789", "88888888");
        Assert.assertEquals(flag,true);
    }
    @Test
    public void printAllEntries(){
        boolean print=addressBook.printAllEntriZs();
        Assert.assertEquals(print,true);
    }
    @Test
    public void  deletePerson() throws IOException {
        boolean deleted=addressBook.deletePerson("vijay");
        Assert.assertEquals(deleted,true);

    }
    @Test
    public void editpersonDetails() throws IOException {
        boolean edited=addressBook.editPersonDetails(1,"city","jaipur");
        Assert.assertEquals(edited,true);
    }
    @Test
    public void sortRecordsByName() throws IOException {
        boolean sortByName=addressBook.sortRecordByFirstName();
        Assert.assertEquals(sortByName,true);
    }

    @Test
    public void sortRecordsByZipCode() throws IOException {
        boolean sortByZip=addressBook.sortRecordByZipCode();
        Assert.assertEquals(sortByZip,true);
    }

    @Test
    public void givenMethode_createNewAddressBookIfCreatesFile_ReturnTrue() throws IOException{
        boolean created= false;
        try {
            created = addressBook.createAddressBook("newFile1");
            Assert.assertEquals(created,true);
        } catch (AddressBookCustumException e) {
            Assert.assertEquals(AddressBookCustumException.ExceptionType.FILE_ALREADY_PRESENT,e.type);
        }
    }
    @Test
    public void givenMethode_createNewAddressBookIfNotCreateFileReturnFalse() throws IOException{
        boolean created= false;
        try {
            created = addressBook.createAddressBook("newFile1");
            Assert.assertEquals(created,true);
        } catch (AddressBookCustumException e) {
            System.out.println("File_Already_Present");
            Assert.assertEquals(AddressBookCustumException.ExceptionType.FILE_ALREADY_PRESENT,e.type);
        }
    }
    @Test
    public void givenMethod_openExistingFileIfFilePresent_ReturnTrue(){
        boolean open= false;
        try {
            open = addressBook.openExistingFile("newFile.json");
            Assert.assertEquals(open,true);
        } catch (AddressBookCustumException e) {
            Assert.assertEquals(AddressBookCustumException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenMethod_openExistingFileIfFileNotPresent_ReturnFalse(){
        boolean open= false;
        try {
            open = addressBook.openExistingFile("newFile33.json");
            Assert.assertEquals(open,true);
        } catch (AddressBookCustumException e) {
            System.out.println("file_Not_Found");
            Assert.assertEquals(AddressBookCustumException.ExceptionType.FILE_NOT_FOUND,e.type);
        }
    }
}


