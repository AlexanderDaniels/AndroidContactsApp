package com.alex.addressbook.domain;

/**
 * Created by alex on 2014/08/19.
 */
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String cellPhoneNumber;
    private String homeAddress;

    public Contact() {
    }

    public Contact(ContactBuilder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        emailAddress = builder.emailAddress;
        cellPhoneNumber = builder.cellPhoneNumber;
        homeAddress = builder.homeAddress;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public static class ContactBuilder{

        private int id;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private String cellPhoneNumber;
        private String homeAddress;

        public ContactBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ContactBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ContactBuilder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public ContactBuilder cellPhoneNumber(String cellPhoneNumber) {
            this.cellPhoneNumber = cellPhoneNumber;
            return this;
        }

        public ContactBuilder homeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public ContactBuilder contactBuilder(Contact contact){
            this.id = contact.getId();
            this.firstName = contact.getFirstName();
            this.lastName = contact.getLastName();
            this.emailAddress = contact.getEmailAddress();
            this.cellPhoneNumber = contact.getCellPhoneNumber();
            this.homeAddress = contact.getHomeAddress();

            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }
}
