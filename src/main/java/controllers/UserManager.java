package controllers;
//package useCases;


import entities.Reading;
import entities.User;
import useCases.LogIn;
import useCases.ReadingLogger;
import useCases.UserGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserManager {

    public static void create_user(String username, String password, int year, int month, int day) {
        UserGenerator.generateUser(username, password, year, month, day);
    }

    public static void login_user(String username, String password) {
        try {
            LogIn.login(username, password);
        }
        catch (Exception e) {
            System.out.println("Wrong password");
        }
    }

    public static void logReading(User user, Reading reading) {
        ReadingLogger readingLogger = new ReadingLogger(user);
        readingLogger.logReading(reading);
    }

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
