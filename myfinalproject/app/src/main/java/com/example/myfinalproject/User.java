package com.example.myfinalproject;

class User {
    private String username,fullName,Email,Gender,Password;

    //create empty constructor
    public User() {

    }

    //create constructor for all fields
    public User(String username, String fullName, String email, String gender, String password) {
        this.username = username;
        this.fullName = fullName;
        Email = email;
        Gender = gender;
        Password = password;
    }

    // create setter and getter for all fields/string
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
