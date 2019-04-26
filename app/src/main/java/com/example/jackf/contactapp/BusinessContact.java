package com.example.jackf.contactapp;

import android.support.annotation.NonNull;

import java.util.Arrays;

public class BusinessContact  extends BaseContact implements Comparable<BusinessContact>{
    private String name;
    private String opening;
    private String closing;
    private boolean[] daysofWeekOpen;
    private String url;
    private int pictureNum;

    public BusinessContact(String name, String Address1, String Address2, String phoneNumber,
                           int pictureNum, String email, String opening, String closing,
                           boolean[] daysofWeekOpen, String url) {
        super(name, Address1, Address2, phoneNumber, email, pictureNum);
        this.pictureNum = pictureNum;
        this.opening = opening;
        this.closing = closing;
        this.daysofWeekOpen = daysofWeekOpen;
        this.url = url;
    }
    //default constructor
    public BusinessContact() {
        super("ThisBusinessName", "BusinessAddress1", "BusinessAddress2", "0987-654-321",  "BusinessEmail@yahoo.com", 1);
        this.opening = "9:00 a.m.";
        this.closing = "10:00 p.m.";
        this.daysofWeekOpen = new boolean[] {false, false, false, false, false, false, false};
        this.url = "http://www.ThisBusiness.com";
    }

    //compareTo for sorting
    @Override
    public int compareTo(@NonNull BusinessContact other) {
        return this.name.compareTo(other.name);
    }

    public String getOpening() {
        return opening;
    }
    public void setOpening(String opening) {
        this.opening = opening;
    }
    public String getClosing() {
        return closing;
    }
    public void setClosing(String closing) {
        this.closing = closing;
    }
    public boolean[] getDaysofWeekOpen() {
        return daysofWeekOpen;
    }
    public void setDaysofWeekOpen(boolean[] daysofWeekOpen) {
        this.daysofWeekOpen = daysofWeekOpen;
    }
    public int getPictureNum() {
        return pictureNum;
    }
    public void setPictureNum(int pictureNum) {
        this.pictureNum = pictureNum;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void openURLPage() {
        System.out.println("Opens url" + this.url);
    }

    @Override
    public String toString() {
        return "Business Contact{" +
                "Name: " + name +
                 "Address1: " + Address1 +
                  "Address2: " + Address2 +
                   "PhoneNumber: " + phone +
                    "pictureNum: " + pictureNum +
                     "Email: " + Email +
                      "BusinessContact opening: " + opening +
                       "closing: " + closing +
                        "DaysofWeekOpen: " + Arrays.toString(daysofWeekOpen) +
                         "Url: " + url +'\'' +
                "}";
    }


}
