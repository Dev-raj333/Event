package com.example.eventmanagement;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String username;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;


    public User(String string, String cursorString, String s, String string1, String cursorString1) {
        // Required empty constructor for Firebase
    }

    public User(String userId, String username, String email, String password, String address, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;

    }


    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
