package useCases;

import controllers.UserManager;
import entities.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserGenerator {
    //Generates and Serializes the User object
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
}