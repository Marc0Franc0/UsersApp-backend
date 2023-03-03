package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.model.Contact;
import java.util.List;
import com.app.repository.ContactRepository;

@Service
public class SContactImpl implements SContact {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Long id) {
        // TODO Auto-generated method stub
        return contactRepository.findById(id).get();
    }

    @Override
    public String createContact(Contact request) {

        Contact contactNuevo = new Contact();
        contactNuevo.setFull_name(request.getFull_name());
        contactNuevo.setEmail(request.getEmail());
        contactNuevo.setBirthdate(request.getBirthdate());
        contactNuevo.setCell_phone(request.getCell_phone());
        contactRepository.save(contactNuevo);
        return "Usuario creado";
    }

    @Override
    public String modifyContact(Long id, Contact request) {

        Contact contactAlmacenado = contactRepository.findById(id).get();
        contactAlmacenado.setId(id);
        contactAlmacenado.setFull_name(request.getFull_name());
        contactAlmacenado.setCell_phone(request.getCell_phone());
        contactAlmacenado.setBirthdate(request.getBirthdate());
        contactAlmacenado.setEmail(request.getEmail());
        contactRepository.save(contactAlmacenado);
        return "Usuario modificado";
    }

}
