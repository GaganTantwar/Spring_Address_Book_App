package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="address_book")
public @Data class AddressBookData {
    @Id
    private long phone;
    @Column(name="FullName")
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    public AddressBookData(){}
    public AddressBookData(long phone,AddressDTO addressDTO){
        this.updateAddressBookData(phone,addressDTO);
    }
    public void updateAddressBookData(long phone, AddressDTO addressDTO){
        this.phone=phone;
        this.name=addressDTO.name;
        this.address=addressDTO.address;
        this.state=addressDTO.state;
        this.city=addressDTO.city;
        this.zipcode=addressDTO.zipcode;
    }
}

