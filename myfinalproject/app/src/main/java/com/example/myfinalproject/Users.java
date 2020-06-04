package com.example.myfinalproject;

import android.provider.ContactsContract;

public class Users {

    public String fullName,username,Email,Password,Gender;

    public Users(){

    }

    public Users(String fullName, String username, String email, String password, String gender) {
        this.fullName = fullName;
        this.username = username;
        Email = email;
        Password = password;
        Gender = gender;
    }
}
