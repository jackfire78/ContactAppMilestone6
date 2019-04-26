package com.example.jackf.contactapp;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BaseContact.class, name = "BaseContact"),
        @JsonSubTypes.Type(value = Person.class, name = "Person"),
        @JsonSubTypes.Type(value = BusinessContact.class, name = "Business")
})
public abstract class BaseContact {
    protected String name;
    protected String Address1;
    protected String Address2;
    protected String phone;
    protected String Email;
    protected int pictureNum;

    public BaseContact(String name, String Address1, String Address2, String phone, String email, int pictureNum) {
        super();
        this.name = name;
        this.Address1 = Address1;
        this.Address2 = Address2;
        this.phone = phone;
        this.Email = email;
        this.pictureNum =pictureNum;
    }

    //default constructor
    public BaseContact() {
        super();
        this.name = "No name";
        this.Address1 = "That address1";
        this.Address2 = "This address2";
        this.phone = "123-456-7890";
        this.Email = "thisEmail@yahoo.com";
        this.pictureNum =1;
    }

    public void callContact() {
        System.out.println("Calling Contact " + this.getName());
    }
    public void textContact() {
        System.out.println("Texting Contact " + this.getName());
    }
    public void emailContact() {
        System.out.println("Emailing Contact " + this.getName());
    }
    public void navigateToContact() {
        System.out.println("Spy cam");
    }

    //@Override
    public int compareTo(BaseContact o) {
        return 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress1() {
        return Address1;
    }
    public void setAddress1(String Address1) {
        this.Address1 = Address1;
    }
    public String getAddrsss2() {
        return Address2;
    }
    public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public int getPictureNum() {
        return pictureNum;
    }

    public void setPictureNum(int pictureNum) {
        this.pictureNum = pictureNum;
    }
}
