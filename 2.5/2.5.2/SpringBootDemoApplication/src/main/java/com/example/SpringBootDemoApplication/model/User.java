package com.example.SpringBootDemoApplication.model;

import com.example.SpringBootDemoApplication.validation.Password;

public class User {

    private String userName;

    @Password
    private String password;

    public User( String userName, String password ) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
