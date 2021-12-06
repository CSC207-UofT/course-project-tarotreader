package controllers;

import entities.User;
import useCases.LogIn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class LoginController {

    // Instance of the singleton
    private static final LoginController controllerInstance = new LoginController();

    private LoginController() {
        // Private constructor so that client-side cannot instantiate this singleton
    }

    /**
     * Instance access method for singleton design pattern
     * @return This instance of LoginController
     */
    public static LoginController getInstance() {
        return controllerInstance;
    } // getter for the singleton instance


    /**
     * Method for accessing the user database and deserializing given user
     * @param username Username of the user to deserialize
     * @param password Password of the user to deserialize
     * @return True iff User file exists and password is match, false otherwise.
     */
    public Object login(String username, String password) {
        User loggedInUser = null;
        //Try-catch block for deserializing User object with the given username and password
        try {
            FileInputStream inputStream = new FileInputStream(username + ".ser"); //Tries to find user file
            ObjectInputStream in = new ObjectInputStream(inputStream);
            loggedInUser = (User) in.readObject(); //Casts to user
            in.close();
            inputStream.close();
            //Passes to the LogIn use case for password check
            LogIn logIn = new LogIn(password, loggedInUser);
            // If the login method returns true, the user is matched and this controller tells the CLI by returning true
            if (logIn.login()) {
                return loggedInUser;
            }
            else {
                return false;
            }
        }
        //Exception handling blocks
        catch(IOException ioException) {
            ioException.printStackTrace();
        }
        catch(ClassNotFoundException fileException) {
            System.out.println("There isn't a user registered with this username");
        }
        catch (ClassCastException castException) {
            System.out.println("");
        }
        return false; // Returns false if an exception is caught, because this means the user does not exist.
    }

}
