package com.example.jackf.contactapp;

import android.app.Application;
import android.content.Context;

import com.example.jackf.contactapp.AddressBook;
import java.util.List;

public class global extends Application {

    private static Context context;

    private static AddressBook globalList;

    public static AddressBook getGlobalList() {
        return  globalList;
    }


    public void onCreate() {
        super.onCreate();
        global.globalList = new AddressBook();
        global.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return global.context;
    }

    public static void setGlobalList(AddressBook addressBook){
        addressBook = addressBook;
    }
}
