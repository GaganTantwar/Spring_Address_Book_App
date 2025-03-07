package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import lombok.Data;
public @Data class AddressBookData {
    private long phone;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    public AddressBookData(){}
    public AddressBookData(long phone, AddressDTO addressDTO){
        this.phone=phone;
        this.name=addressDTO.name;
        this.address=addressDTO.address;
        this.state=addressDTO.state;
        this.city=addressDTO.city;
        this.zipcode=addressDTO.zipcode;
    }
}

