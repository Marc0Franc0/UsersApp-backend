package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Contact;
import com.app.service.SContact;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    SContact contactService;

    @GetMapping( "/")
    public ResponseEntity< List<Contact>> getAllContacts() {

        return ResponseEntity.status(HttpStatus.OK).body(contactService.getAllContacts()) ;
    }

    @GetMapping( "/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContact(id)) ;
    }
    
    @PostMapping( "/new")
    public ResponseEntity<String> createContact (@RequestBody Contact contact) {

        return ResponseEntity.status(HttpStatus.OK).body(contactService.createContact(contact)) ;
    }

    @PutMapping( "/{id}")
    public ResponseEntity<String> modifycontact (@PathVariable Long id,@RequestBody Contact contact) {

        return ResponseEntity.status(HttpStatus.OK).body(contactService.modifyContact(id, contact));
    }
}
