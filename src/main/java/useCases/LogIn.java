package useCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;
import useCases.UserGenerator;

import entities.User;

//A class to handle the Login functionality for different users
public class LogIn {

    private final String password;
    private final User loggedinUser;

    public LogIn(String password, User loggedinUser) {
        this.password = password;
        this.loggedinUser = loggedinUser;
    }

    /**
     *
     * @return Returns the logged-in User if such user exists.
     */
    public boolean login() {
        //This try block tries to deserialize the user based on filename (the name of the user)
        return Objects.equals(loggedinUser.getPassword(), password);
    }

}
