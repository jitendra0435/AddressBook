package com.objectoriented;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook implements AddressBookInterface {
    static String CONTACT_DETAILS_JSON= "/home/admin1/ObjectOriented/src/test/resources/addressBOOK.JSON";
    AddressBookPOJO addressBookPOJO = new AddressBookPOJO();
    List<AddressBookPOJO>addDetails=new ArrayList<>();
    public AddressBook() throws FileNotFoundException {
    }

    @Override
    public void addNewPesonInto_AddressBook(String firstName,String lastName,String state, String city, String address, int zipCode,int phoneNumber) throws IOException {
        addressBookPOJO.setFirstName(firstName);
        addressBookPOJO.setLastName(lastName);
        addressBookPOJO.setState(state);
        addressBookPOJO.setCity(city);
        addressBookPOJO.setAddress(address);
        addressBookPOJO.setZipCode(zipCode);
        addressBookPOJO.setPhoneNumber(phoneNumber);
        addDetails.add(addressBookPOJO);
        writeIntoJSON(addDetails);
    }
    private static void writeIntoJSON(List<AddressBookPOJO> addDetails) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(addDetails);
        FileWriter writer = new FileWriter(CONTACT_DETAILS_JSON);
        writer.write(json);
        writer.close();
    }

}
