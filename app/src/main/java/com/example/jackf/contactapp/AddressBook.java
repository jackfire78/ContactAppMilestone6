/*
This class is used to create the contact list.
This includes the add contact and delete contact methods.
It also includes the searchFor methods to search personal and business contacts.
*/
package com.example.jackf.contactapp;

import java.util.ArrayList;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    //@JsonIgnoreProperties
    public class AddressBook {
    private List<BaseContact> ContactList;

    public AddressBook() {
        this.ContactList = new ArrayList<BaseContact>();
     /*   Person Per = new Person(2, "Jack Sidrak", 18, "4806526448", "jackfire78@yahoo.com", "14430 N 19th Ave", "Apt#44", "Clone", "My only clone made");
        ContactList.add(Per);
        boolean[] daysopen = new boolean[]{true, false, false, false, true, true, false};
        BusinessContact Bus = new BusinessContact("Swoop Media", "17802 N 19th Ave", "85023", "6025399760", 5, "swoopmediaaz@gmail.com", "09:00am", "08:30pm", daysopen, "swoopmediaaz.com");
        ContactList.add(Bus); */
        //this.writeList(ContacctAppBusinessService.List, "contacts.txt");

    }

    public <T extends BaseContact> void addOne(T contact) {
        this.ContactList.add(contact);
    }

    public <T extends BaseContact> void deleteOne(T contact) {
        if (this.ContactList.contains(contact)) {
            this.ContactList.remove(contact);
        }

    }

 /*   //@JsonIgnore
    public ArrayList<BaseContact> searchFor(String searchLetters) {
        ArrayList<BaseContact> newList = new ArrayList<BaseContact>();
        for (int i = 0; i < ContactList.size(); i++) {
            if (ContactList.get(i).getName().contains(searchLetters)) {
                newList.add(ContactList.get(i));
            }
        }
        return newList;
    }

    //@JsonIgnore
    public ArrayList<BaseContact> searchForBusiness(String searchLetters) {
        ArrayList<BaseContact> newList = new ArrayList<BaseContact>();
        for (int i = 0; i < ContactList.size(); i++) {
            if (ContactList.get(i).getClass() == BusinessContact.class && ContactList.get(i).getName().contains(searchLetters)) {
                newList.add(ContactList.get(i));
            }
        }
        return newList;
    }*/

    public AddressBook searchFor(String search) {
        AddressBook foundContacts = new AddressBook();
        //if statement to look for contacts using contact parameters
        for (int i = 0; i < global.getGlobalList().getLists().size(); i++) {
            if (global.getGlobalList().get(i).getName().contains(search)) {
                foundContacts.getLists().add(global.getGlobalList().get(i));
            } else if (global.getGlobalList().get(i).getPhone().contains(search)) {
                foundContacts.getLists().add(global.getGlobalList().get(i));
            }
        }
        return foundContacts;
    }

        @Override
        public String toString() {
            return "AddressBook{" +
                    "ContactList: " + ContactList +
                    '}';
        }

        public BaseContact get(int i) {
            // TODO Auto-generated method stub
            return ContactList.get(i);
        }

        public List<BaseContact> getLists() {
            // TODO Auto-generated method stub
            return ContactList;
        }
    }
