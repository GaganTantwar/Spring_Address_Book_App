package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressDTO;

public class AddressBookData {
    private long phone;
    private String name;
    private String address;
    public AddressBookData(){}
    public AddressBookData(long phone, AddressDTO addressDTO){
        this.phone=phone;
        this.name=addressDTO.name;
        this.address=addressDTO.address;
    }
    public long getPhone(){
        return phone;
    }
    public void setPhone(long phone){
        this.phone=phone;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
}

