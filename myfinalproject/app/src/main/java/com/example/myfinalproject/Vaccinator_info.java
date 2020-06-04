package com.example.myfinalproject;

public class Vaccinator_info {

    private String userName,password;

    public Vaccinator_info() {

    }

    public Vaccinator_info(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
