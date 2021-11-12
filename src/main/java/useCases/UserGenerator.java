package useCases;

import controllers.UserManager;
import entities.User;

public class UserGenerator{
    //creates a new user object based on inputs from user manager
    // date, user name, password and age
    String username;
    String birthday;
    String password;
    public UserGenerator(String initUserName, String initBirthday, String initPassword){
        username = initUserName;
        birthday = initBirthday;
        password = initPassword;
        // creates a new user object
        UserManager User = new UserManager(initUserName, initBirthday, initPassword);
    }

    public String getPassword() {
        return password;
    }
    public String getUsername(){
        return username;
    }
    public String getBirthday(){
        return birthday;
    }
}
