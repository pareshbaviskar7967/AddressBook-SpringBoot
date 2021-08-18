package com.example.addressbook_springboot.repository;

import com.example.addressbook_springboot.model.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRespository extends JpaRepository<PersonDetails,Integer> {
}
