package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressBookAppService implements InterfaceAddressBookAppService {

    // List to store address book data
    List<AddressBookData> addressBookList = new ArrayList<>();

    // Method to get all address book data
    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookList;
    }

    // Method to get address book data by phone number
    @Override
    public AddressBookData getAddressBookDataByPhone(long phone) {
        return addressBookList.stream().filter(empData->empData.getPhone()==phone).findFirst().orElseThrow(()->new AddressBookException("Person Not Found"));// Return null if no data is found
    }

    // Method to create new address book data
    @Override
    public AddressBookData createAddressBookData(long phone, AddressDTO data) {
        AddressBookData addData = null;
        addData = new AddressBookData(phone, data); // Create new address book data
        addressBookList.add(addData); // Add new data to the list
        return addData;
    }

    // Method to update existing address book data
    @Override
    public AddressBookData updateAddressBookData(long phone, AddressDTO data) {
        AddressBookData updateData = this.getAddressBookDataByPhone(phone); // Find existing data by phone number
        int index = addressBookList.indexOf(updateData); // Get index of the existing data
        updateData.setAddress(data.address); // Update address
        updateData.setName(data.name); // Update name
        updateData.setPhone(phone); // Update phone number
        addressBookList.set(index, updateData); // Replace the existing data with updated data
        return updateData;
    }

    // Method to delete address book data by phone number
    @Override
    public void deleteAddressBookData(long phone) {
        Iterator<AddressBookData> iterator = addressBookList.iterator();
        while (iterator.hasNext()) {
            AddressBookData address = iterator.next();
            if (address.getPhone() == phone) {
                iterator.remove(); // Remove the data from the list
            }
        }
    }
}
