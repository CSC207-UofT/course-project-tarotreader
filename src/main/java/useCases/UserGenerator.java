package useCases;

import controllers.UserManager;

public class UserGenerator{
    //creates a new user object based on inputs from user manager
    // date, user name, password and age
    String UserName;
    int age;
    String date;
    String password;
    public UserGenerator(String initUserName, int initAge, String initDate, String initPassword){
        UserName = initUserName;
        age = initAge;
        date = initDate;
        password = initPassword;


        UserManager User = new UserManager(initUserName, initAge, initDate, initPassword);
    }
}

