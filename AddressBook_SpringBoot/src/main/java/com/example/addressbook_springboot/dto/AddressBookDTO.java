package com.example.addressbook_springboot.dto;

import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public @ToString
class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "Person Name cannot be Correct")
    @NotEmpty(message = "Please enter the Name")
    public String name;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "Address cannot be Correct")
    @NotNull(message = "Please enter the address")
    public String address;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "City Name cannot be Correct")
    @NotNull(message = "Please enter the city")
    public String city;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "State Name cannot be Correct")
    @NotNull(message = "Please enter the state")
    public String state;

    @Pattern(regexp = "^[a-z]{1}[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.]+[a-zA-z]{2,3}$",message = "Email ID cannot be Correct")
    @NotNull(message = "Please enter the email")
    public String email;

    @Pattern(regexp = "^[+]{0,1}[0-9]{2,3}[: :][7-9]{1}[0-9]{9}$",message = "Contact Number cannot be Correct")
    @NotNull(message = "Please enter the Mob. No.")
    public String contactno;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2,3}\\\\s{0,1}[0-9]{3}$",message = "Zipcode cannot be Correct")
    @NotNull(message = "Please enter the zipcode")
    public long zipcode;

}
