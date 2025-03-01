package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.AddressBookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    private AddressBookAppService addressBookAppService;

    // Endpoint to get a generic message indicating a successful call to the Address Book API
    @RequestMapping(value={"","/","address"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBookData> addData=null;
        addData=addressBookAppService.getAddressBookData();
        ResponseDTO responseDTO=new ResponseDTO("Get Call Succesful ",addData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Endpoint to get address book data by phone number
    @GetMapping("/get/{phone}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("phone") long phone){
        AddressBookData addData=null;
        addData=addressBookAppService.getAddressBookDataByPhone(phone);
        ResponseDTO responseDTO=new ResponseDTO("Get Call Success Full by Phone Number ",addData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    // Endpoint to create new address book data
    @PostMapping("/create/{phone}")
    public ResponseEntity<ResponseDTO> addAddressBookData(@PathVariable ("phone") long phone,@RequestBody AddressDTO addressDTO){
        AddressBookData addData=null;
        addData=addressBookAppService.createAddressBookData(phone,addressDTO);
        ResponseDTO responseDTO=new ResponseDTO("Creation of Address Book Data is Successfull ",addData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    // Endpoint to update existing address book data
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressDTO addressDTO){
        AddressBookData addData=null;
        addData=addressBookAppService.updateAddressBookData(addressDTO);
        ResponseDTO responseDTO=new ResponseDTO("Updation of Address book Data is Successful",addData);
        return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Endpoint to delete address book data by phone number
    @DeleteMapping("/delete/{phone}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("phone") long phone){
        ResponseDTO responseDTO=new ResponseDTO("Deletion of Employee Book Data is Successful by Phone",phone);
        return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
