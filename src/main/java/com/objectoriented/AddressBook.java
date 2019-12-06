package com.objectoriented;
import com.google.gson.Gson;
import java.io.*;
import java.util.*;

public class AddressBook implements AddressBookInterface {
    static String CONTACT_DETAILS_JSON = "/home/admin1/ObjectOriented/src/test/resources/addressBOOK.JSON";
    AddressBookPOJO addressBookPOJO = new AddressBookPOJO();
    Gson gson = new Gson();
    BufferedReader br = new BufferedReader(new FileReader(CONTACT_DETAILS_JSON));
    AddressBookPOJO[] personDetails = gson.fromJson(br, AddressBookPOJO[].class);
    List<AddressBookPOJO> addDetails = new ArrayList<>();

    public AddressBook() throws FileNotFoundException {
    }

    @Override
    public void addNewPesonInto_AddressBook(String firstName, String lastName, String state, String city, String address, String zipCode, String phoneNumber) throws IOException {
        addressBookPOJO.setFirstName(firstName);
        addressBookPOJO.setLastName(lastName);
        addressBookPOJO.setState(state);
        addressBookPOJO.setCity(city);
        addressBookPOJO.setAddress(address);
        addressBookPOJO.setZipCode(zipCode);
        addressBookPOJO.setPhoneNumber(phoneNumber);
        addDetails.add(addressBookPOJO);
        if (personDetails != null) {
            readJsonDocument();
        }
        writeIntoJSON(addDetails);
    }

    private static void writeIntoJSON(List<AddressBookPOJO> addDetails) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(addDetails);
        FileWriter writer = new FileWriter(CONTACT_DETAILS_JSON);
        writer.write(json);
        writer.close();
    }

    public void readJsonDocument() {
        for (int records = 0; records < personDetails.length; records++) {
            if (personDetails[records] != null) {
                addDetails.add(personDetails[records]);
            }
        }
    }
    @Override
    public void printAllEntriZs() {
        if (personDetails != null) {
            for (int entries = 0; entries < personDetails.length; entries++) {
                System.out.println(personDetails[entries].firstName +"\t"+personDetails[entries].lastName+"\t"
                +personDetails[entries].zipCode+"\t"+personDetails[entries].city+"\n");
            }
        }
    }
    @Override
    public void deletePerson(String firstName) throws IOException {
        if (personDetails != null)
            for (int entries = 0; entries < personDetails.length; entries++) {
                if (!personDetails[entries].firstName.equals(firstName)) {
                    addDetails.add(personDetails[entries]);
                }
            }
        writeIntoJSON(addDetails);
    }

    @Override
    public void editPersonDetails(int index, String property, String updatedValue) throws IOException {
        readJsonDocument();
                if (property.equals("city"))
                    personDetails[index].setCity(updatedValue);
                else if (property.equals("state"))
                    personDetails[index].setState(updatedValue);
                else if (property.equals("zipCode"))
                    personDetails[index].setState(updatedValue);
                else if (property.equals("phoneNumber"))
                    personDetails[index].setState(updatedValue);
                addDetails.add(addressBookPOJO);
                writeIntoJSON(addDetails);
        }

    @Override
    public void sortRecordByFirstName() throws IOException {
        readJsonDocument();
        Comparator<AddressBookPOJO> comparing = Comparator.comparing(AddressBookPOJO::getFirstName);
        addDetails.sort(comparing);
        writeIntoJSON(addDetails);
    }

    @Override
    public void sortRecordByZipCode() throws IOException {
        readJsonDocument();
        Comparator<AddressBookPOJO> comparing=Comparator.comparing(AddressBookPOJO::getZipCode);
        addDetails.sort(comparing);
        writeIntoJSON(addDetails);
    }

    @Override
    public boolean createAddressBook(String fileName) throws IOException, AddressBookCustumException {
        String path="/home/admin1/ObjectOriented/src/test/resources/";
        File file=new File(path+fileName+".json");
        if(file.exists())
            throw new AddressBookCustumException(AddressBookCustumException.ExceptionType.FILE_ALREADY_PRESENT);
        else
        file.createNewFile();
        List<String> newlist = new ArrayList<>();
        String json = gson.toJson(newlist);
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();
        return true;
    }

}


