package controllers;
//package useCases;


import entities.Reading;
import entities.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserManager {

    /**
     * Updates User's serialization file
     * @param user User to update
     */
    public static void updateUser(User user) {
        try {
            FileOutputStream outFile = new FileOutputStream(user.getUsername() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(user); //writes the user to "username.ser"
            out.close();
            outFile.close();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
