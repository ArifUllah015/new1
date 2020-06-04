package com.example.myfinalproject;

public class ChildData {

    private String add_childname, Address, contact_number, country_name,Date;
    String childDataID;

    public ChildData(){

    }


    public String getChildDataID() {
        return childDataID;
    }

    public void setChildDataID(String childDataID) {
        this.childDataID = childDataID;
    }

    public String getAdd_childname() {
        return add_childname;
    }

    public void setAdd_childname(String add_childname) {
        this.add_childname = add_childname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
