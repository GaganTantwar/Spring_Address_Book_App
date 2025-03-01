package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    // Endpoint to get a generic message indicating a successful call to the Address Book API
    @RequestMapping(value={"","/","address"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        AddressBookData addData=null;
        addData=new AddressBookData(9996633321L,new AddressDTO("Rahul","HNo 90 Kamala Colony"));
        ResponseDTO responseDTO=new ResponseDTO("Get Call Succesful ",addData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Endpoint to get address book data by phone number
    @GetMapping("/get/{phone}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("phone") long phone){
        AddressBookData addData=null;
        addData=new AddressBookData(6632147852L,new AddressDTO("Rajesh","HNo 89 Ganesh Colony"));
        ResponseDTO responseDTO=new ResponseDTO("Get Call Success Full by Phone Number ",addData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    // Endpoint to create new address book data
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressDTO addressDTO){
        AddressBookData addData=null;
        addData=new AddressBookData(9632145674L,new AddressDTO(addressDTO.name,addressDTO.address));
        ResponseDTO responseDTO=new ResponseDTO("Creation of Address Book Data is Successfull ",addData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    // Endpoint to update existing address book data
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressDTO addressDTO){
        AddressBookData addData=null;
        addData=new AddressBookData(8875452316L,new AddressDTO(addressDTO.name,addressDTO.address));
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
