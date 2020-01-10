package com.sut.cpe.healthInsurance.controller;
import com.sut.cpe.healthInsurance.repository.ContactRepository;
import com.sut.cpe.healthInsurance.entity.Contact;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;





@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ContactController {

    @Autowired
    private final ContactRepository contactRepository;

    public  ContactController(ContactRepository  contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contact")
    public Collection<Contact> Contacts() {
        return contactRepository.findAll().stream().collect(Collectors.toList());
    }
}