package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    // Endpoint to get a generic message indicating a successful call to the Address Book API
    @RequestMapping(value={"","/","address"})
    public ResponseEntity<String> getAddressBookData(){
        return new ResponseEntity<String>("Get Call for Address Book Success:", HttpStatus.OK);
    }

    // Endpoint to get address book data by phone number
    @GetMapping("/get/{phone}")
    public ResponseEntity<String> getAddressBookData(@PathVariable("phone") long phone){
        return new ResponseEntity<String>("Get Call for Address Book by Phone Number is Success: "+phone, HttpStatus.OK);
    }

    // Endpoint to create new address book data
    @PostMapping("/create")
    public ResponseEntity<String> addAddressBookData(@RequestBody AddressDTO addressDTO){
        return new ResponseEntity<String>("Created Address Book Data for "+addressDTO, HttpStatus.OK);
    }

    // Endpoint to update existing address book data
    @PutMapping("/update")
    public ResponseEntity<String> updateAddressBookData(@RequestBody AddressDTO addressDTO){
        return new ResponseEntity<String>("Updated Address Book Data for "+addressDTO, HttpStatus.OK);
    }

    // Endpoint to delete address book data by phone number
    @DeleteMapping("/delete/{phone}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("phone") long phone){
        return new ResponseEntity<String>("Deleted Address Book Data by Phone Number: "+phone, HttpStatus.OK);
    }
}
