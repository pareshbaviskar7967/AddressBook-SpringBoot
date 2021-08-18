package com.example.addressbook_springboot.service;

import com.example.addressbook_springboot.dto.AddressBookDTO;
import com.example.addressbook_springboot.model.PersonDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonService {

    public List<PersonDetails> getPersonDetails();

    public PersonDetails getPersonDetailsById(int personId);

    public PersonDetails createPersonDetails(AddressBookDTO addBookDTO);

    public PersonDetails updatePersonDetails(int personId,AddressBookDTO addBookDTO);

    public void deletePersonDetailsById(int personId);

}

