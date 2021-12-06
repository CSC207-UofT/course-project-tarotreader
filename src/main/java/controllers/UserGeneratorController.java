package controllers;

import entities.User;
import useCases.UserGenerator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UserGeneratorController {

    private static final UserGeneratorController controllerInstance = new UserGeneratorController();

    private UserGeneratorController(){
        // Private constructor so that client-side cannot instantiate this singleton
    }

    public static UserGeneratorController getInstance() {return controllerInstance;}

    public Object generateUser(String username, String password, int year, int month, int day) {
        UserGenerator userGenerator = new UserGenerator();
        try {
            UserGenerator.generateUser(username, password, year, month, day);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public static User getExistingUser(String username) {
        User existingUser = null;
        try {
            FileInputStream inputStream = new FileInputStream(username + ".ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            existingUser = (User) in.readObject();
            in.close();
            inputStream.close();
        }
        catch (FileNotFoundException ex){
            return existingUser;
        }
        catch(ClassNotFoundException | IOException ioException) {
            ioException.printStackTrace();
        }
        return existingUser;
    }
}
