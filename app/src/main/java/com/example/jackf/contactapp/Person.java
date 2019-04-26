package com.example.jackf.contactapp;

import android.support.annotation.NonNull;

public class Person extends BaseContact implements Comparable<Person> {
    private String name;
    private int age;
    private int pictureNum;
    private String phone;
    private String email;
    private String address1;
    private String address2;
    private String relationship;
    private String description;

    public Person(int pictureNum,String name, int age, String phone, String email,
                  String address1, String address2, String relationship, String description){
        this.pictureNum = pictureNum;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.relationship = relationship;
        this.description = description;
    }
    //default constructor
    public Person() {
        super("name", "PersonAddress1", "PersonAddress2", "135-792-4680", "PersonEmail@yahoo.com", 1);
        this.name = "name";
        this.description = "Random Decscription";
        this.relationship = "Buddy";
        this.age = 18;
    }

    //compareTo for sorting
    @Override
    public int compareTo(@NonNull Person other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getPictureNum() {
        return pictureNum;
    }
    public void setPictureNum(int pictureNum) {
        this.pictureNum = pictureNum;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Person{" +
                "PictureNum" + pictureNum +
                 "Name: " + name +
                  "Age: " + age +
                   "Phone: " + phone +
                    "Email: " + Email +
                     "Address1: " + Address1 +
                      "Address2: " + Address2 +
                       "Relationship: " + relationship +
                        "Description: " + description +'\'' +
                "}";
    }


}
