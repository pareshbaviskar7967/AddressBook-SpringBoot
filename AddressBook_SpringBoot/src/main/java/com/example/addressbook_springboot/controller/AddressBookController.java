package com.example.addressbook_springboot.controller;

import java.util.List;

import com.example.addressbook_springboot.dto.AddressBookDTO;
import com.example.addressbook_springboot.dto.ResponseDTO;
import com.example.addressbook_springboot.model.PersonDetails;
import com.example.addressbook_springboot.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IPersonService personService;

    @RequestMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getPersonDetails()
    {
        List<PersonDetails> personDetailsList = personService.getPersonDetails();
        ResponseDTO resDTO = new ResponseDTO("Getting All Details", personDetailsList);
        return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);

    }
    @GetMapping("/{personId}")
    public ResponseEntity<ResponseDTO> getPersonDetails(@PathVariable("personId") int personId)
    {
        PersonDetails personData = personService.getPersonDetailsById(personId);
        ResponseDTO resDTO = new ResponseDTO("Getting Details with Id :", personData);
        return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createPersonDetails(@Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        PersonDetails personData = personService.createPersonDetails(addressBookDTO);
        ResponseDTO resDTO = new ResponseDTO("Create Personal Details Addressbook for :", personData);
        return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updatePersonDetails(@PathVariable("personId") int personId,@RequestBody AddressBookDTO addressBookDTO)
    {
        PersonDetails personData = personService.updatePersonDetails(personId, addressBookDTO);
        ResponseDTO resDTO = new ResponseDTO("Updated Personal Details Addressbook for :", personData);
        return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deletePersonDetailsById(@PathVariable("personId") int personId)
    {
        personService.deletePersonDetailsById(personId);
        ResponseDTO resDTO = new ResponseDTO("Delete Successfully", "Deleted for id :" +personId);
        return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
    }

}