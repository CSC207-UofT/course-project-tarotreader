package useCases;

import controllers.UserManager;
import entities.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

    public static void generateUser(String username, String password, int year, int month, int day) {
        User user = new User(username, password, year, month, day);
        try {
            FileOutputStream outFile = new FileOutputStream("/users/" + username + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(user);
            out.close();
            outFile.close();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
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
