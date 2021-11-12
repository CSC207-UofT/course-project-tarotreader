package controllers;

import useCases.UserGenerator;

public class UserManager {
    // instance variables
    private String UserName;
    private int age;
    private String password;
    private String date;

    // UserManager constructor

    public UserManager(String initUserName, int initAge, String initPassword, String initDate){
        UserName = initUserName;
        age = initAge;
        password = initPassword;
        date = initDate;
    }
}