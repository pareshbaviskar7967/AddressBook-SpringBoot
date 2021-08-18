package com.example.addressbook_springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class AddressBookSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookSpringBootApplication.class, args);
        log.info("Address Book App Started");
    }

}
