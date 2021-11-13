package useCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

import entities.User;

public class LogIn {

    public static User loginBetter(String username, String password) throws WrongPasswordException {
        User loggedInUser = null;
        try {
            FileInputStream inputStream = new FileInputStream("/users/" + username + ".ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            loggedInUser = (User) in.readObject();
            in.close();
            inputStream.close();
            if (Objects.equals(loggedInUser.getPassword(), password)) {
                return loggedInUser;
            }
            else {
                throw new WrongPasswordException("Wrong password");
            }
        }
        catch(IOException ioException) {
            ioException.printStackTrace();
        }
        catch(ClassNotFoundException fileException) {
            System.out.println("There isn't a user registered with this username");
        }
        return loggedInUser;
    }

    private static class WrongPasswordException extends Exception {
        public WrongPasswordException(String errorMessage) {
            super(errorMessage);
        }
    }
}
