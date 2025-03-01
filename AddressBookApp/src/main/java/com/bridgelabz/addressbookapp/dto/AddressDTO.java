package com.bridgelabz.addressbookapp.dto;

public class AddressDTO {
    public String name;
    public String address;
    public AddressDTO(String name,String address){
        this.name=name;
        this.address=address;
    }
    @Override
    public String toString(){
        return "Address "+name +" "+address+" ";
    }
}
