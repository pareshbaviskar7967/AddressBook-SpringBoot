package com.example.addressbook_springboot.service;

import com.example.addressbook_springboot.dto.AddressBookDTO;
import com.example.addressbook_springboot.exceptions.AddressBookException;
import com.example.addressbook_springboot.model.PersonDetails;
import com.example.addressbook_springboot.repository.AddressBookRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService implements IPersonService {
    @Autowired
    private AddressBookRespository addressRespository;

    @Override
    public List<PersonDetails> getPersonDetails() {
        return addressRespository.findAll();
    }

    @Override
    public PersonDetails getPersonDetailsById(int personId) {
        return addressRespository.findById(personId)
                .orElseThrow(() -> new AddressBookException("AddressBook with personId " + personId + " does not exists...!"));
    }

    @Override
    public PersonDetails createPersonDetails(AddressBookDTO addBookDTO) {
        PersonDetails personData = new PersonDetails(addBookDTO);
        BeanUtils.copyProperties(addBookDTO, personData);
        log.debug("Person Data:"+personData.toString());
        return addressRespository.save(personData);
    }

    @Override
    public PersonDetails updatePersonDetails(int personId, AddressBookDTO addBookDTO) {
        PersonDetails personData = this.getPersonDetailsById(personId);
        personData.updatePersonDetails(addBookDTO);
        return addressRespository.save(personData);
    }


    @Override
    public void deletePersonDetailsById(int personId) {
        PersonDetails personData = this.getPersonDetailsById(personId);
        addressRespository.delete(personData);
    }
}
