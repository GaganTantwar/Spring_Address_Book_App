package com.bridgelabz.addressbookapp.service;
import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

import java.util.*;
public interface InterfaceAddressBookAppService {
    List<AddressBookData> getAddressBookData();
    AddressBookData getAddressBookDataByPhone(long phone);
    AddressBookData createAddressBookData(long phone,AddressDTO addressDTO);
    AddressBookData updateAddressBookData(AddressDTO addressDTO);
    void deleteAddressBookData(long phone);
}
