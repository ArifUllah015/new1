package com.example.myfinalproject;

public class ChildrenData {
    private String address,contact_number,date,country_name,add_childname,childDataID;

    //create empty constructor
    public ChildrenData() {

    }

    //create constructor for all fields
    public ChildrenData(String address, String contact_number, String date, String country_name, String add_childname, String childDataID) {
        this.address = address;
        this.contact_number = contact_number;
        this.date = date;
        this.country_name = country_name;
        this.add_childname = add_childname;
        this.childDataID = childDataID;
    }

    // create setter and getter for all fields/string
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getAdd_childname() {
        return add_childname;
    }

    public void setAdd_childname(String add_childname) {
        this.add_childname = add_childname;
    }

    public String getChildDataID() {
        return childDataID;
    }

    public void setChildDataID(String childDataID) {
        this.childDataID = childDataID;
    }
}
