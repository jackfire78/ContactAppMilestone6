package com.example.jackf.contactapp;

import android.content.Context;
import android.provider.ContactsContract;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataService {
    Context context;

    ObjectMapper om = new ObjectMapper();

    public DataService(Context context){
        this.context = context;
        Person Per = new Person(2, "Jack Sidrak", 18, "4806526448", "jackfire78@yahoo.com", "14430 N 19th Ave", "Apt#44", "Clone", "My only clone made");
        global.getGlobalList().addOne((Per));
        boolean[] daysopen = new boolean[]{true,false,false,false,true,true,false};
        BusinessContact Bus = new BusinessContact("Swoop Media", "17802 N 19th Ave", "85023", "6025399760", 5, "swoopmediaaz@gmail.com", "09:00am","08:30pm",daysopen , "swoopmediaaz.com");
        global.getGlobalList().addOne((Bus));
        this.writeList(global.getGlobalList(), "contacts.txt");
    }

    public void writeList(AddressBook List, String filename){
        File path = context.getExternalFilesDir(null);
        File file = new File(path,filename);
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(file, List);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public AddressBook readList (String filename){
        File path = context.getExternalFilesDir(null);
        File file = new File(path,filename);
        AddressBook returnList = new AddressBook();

        try{
            returnList = om.readValue(file, AddressBook.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return returnList;
    }


}
