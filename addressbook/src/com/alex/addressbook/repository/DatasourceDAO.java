package com.alex.addressbook.repository;

import com.alex.addressbook.domain.Contact;

import java.util.List;

/**
 * Created by alex on 2014/08/19.
 */
public interface DatasourceDAO {

    public void createContact(Contact contact);
    public List<Contact> viewContact();
    public String searchLastName(String searchValue);

}
