package controllers;

import useCases.UserGenerator;

public class UserManager {
    // instance variables
    private String UserName;
    private String password;
    private String date;

    // UserManager constructor

    public UserManager(String initUserName, String initPassword, String initDate){
        UserName = initUserName;
        password = initPassword;
        date = initDate;
    }
}
