package com.example.addressbook_springboot.model;

import javax.persistence.Column;
import javax.persistence.*;

import com.example.addressbook_springboot.dto.AddressBookDTO;
import lombok.Data;

@Entity
@Table(name = "person_details")
public @Data
class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_Id")
    private int personId;

    @Column(name = "name")
    public String name;
    public String address;
    public String city;
    public String state;
    public String email;
    public String contactno;
    public long zipcode;

    public PersonDetails() {
    }

    public PersonDetails(AddressBookDTO addBookDTO) {

        this.name = addBookDTO.name;
        this.address = addBookDTO.address;
        this.city = addBookDTO.city;
        this.state = addBookDTO.state;
        this.email = addBookDTO.email;
        this.contactno = addBookDTO.contactno;
        this.zipcode = addBookDTO.zipcode;
    }

    public void updatePersonDetails(AddressBookDTO addBookDTO) {
    }

   /* public void updatePersonDetails(AddressBookDTO addBookDTO) {
    }*/
}