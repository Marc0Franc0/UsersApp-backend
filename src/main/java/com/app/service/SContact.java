package com.app.service;

import org.springframework.stereotype.Service;
import com.app.model.Contact;
import java.util.List;

@Service
public interface SContact {
    public List<Contact> getAllContacts();
    public Contact getContact(Long id);
    public String createContact(Contact contact);
    public String modifyContact(Long id,Contact contact);
}
