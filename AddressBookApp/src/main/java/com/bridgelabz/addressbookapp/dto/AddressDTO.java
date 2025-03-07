package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;
public class AddressDTO {
    @NotEmpty(message = "Name Should not be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = " Name Should be Valid")
    public String name;
    @NotEmpty(message = "Addres Should not Empty")
    public String address;
    public String city;
    public String state;
    public String zipcode;

}
