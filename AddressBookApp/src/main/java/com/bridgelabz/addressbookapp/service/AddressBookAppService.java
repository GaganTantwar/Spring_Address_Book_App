package com.bridgelabz.addressbookapp.service;
import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class AddressBookAppService implements InterfaceAddressBookAppService {
    public List<AddressBookData> getAddressBookData(){
        List<AddressBookData> addressBookList=new ArrayList<>();
        addressBookList.add((new AddressBookData(9632145782L,new AddressDTO("Kamal","HNo 65 Mataram Colony"))));
        return addressBookList;
    }
    public AddressBookData getAddressBookDataByPhone(long phone){
        AddressBookData addData=null;
        addData=new AddressBookData(9654217832L,new AddressDTO("Kajal","HNo 85 Jagnath Apartments"));
        return addData;
    }
    public AddressBookData createAddressBookData(long phone,AddressDTO data){
        AddressBookData addData=null;
        addData=new AddressBookData(phone,data);
        return addData;
    }
    public AddressBookData updateAddressBookData(AddressDTO data){
        AddressBookData addData=null;
        addData=new AddressBookData(8745219632L,data);
        return addData;
    }
    public void deleteAddressBookData( long phone){

    }
}
