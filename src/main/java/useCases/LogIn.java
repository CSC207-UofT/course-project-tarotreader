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

    private final String username;
    private final String password;

    public LogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return Returns the logged in User if such user exists.
     * @throws WrongPasswordException Throws exception to tell the command line interface to prompt the user for username and password again
     */
    public User login() throws WrongPasswordException {

        User loggedInUser = null; //initialize the User object as null
        //This try block tries to deserialize the user based on filename (the name of the user)
        try {
            FileInputStream inputStream = new FileInputStream(username + ".ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            loggedInUser = (User) in.readObject();
            in.close();
            inputStream.close();
            //Returns the logged in user if the passwords match.
            if (Objects.equals(loggedInUser.getPassword(), password)) {
                return loggedInUser;
            }
            //else throws exception to tell the command line interface to prompt the user for username and password again
            else {
                throw new WrongPasswordException("Wrong password");
            }
        }
        //Exception handling blocks
        catch(IOException ioException) {
            ioException.printStackTrace();
        }
        catch(ClassNotFoundException fileException) {
            System.out.println("There isn't a user registered with this username");
        }
        return loggedInUser;
    }

    //Exception class for specific case of wrong passwords.
    private class WrongPasswordException extends Exception {
        public WrongPasswordException(String errorMessage) {
            super(errorMessage);
        }
    }
}
