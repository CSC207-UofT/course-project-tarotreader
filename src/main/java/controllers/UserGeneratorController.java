package controllers;

import entities.User;
import useCases.UserGenerator;

import java.io.*;

public class UserGeneratorController {

    private static final UserGeneratorController controllerInstance = new UserGeneratorController();

    private UserGeneratorController(){
        /*
        Private constructor so that client-side cannot instantiate this singleton
         */
    }

    public static UserGeneratorController getInstance() {return controllerInstance;}

    public Object generateUser(String username, String password, int year, int month, int day) {
        /*
        Generates and Serializes the User object. Try to deserialize the User from its filename(username.ser)
         */
        UserGenerator userGenerator = new UserGenerator();
        User user = null;
        if (userExists(username)){
            System.out.println("Username already exists!");
        }
        else{
            if (!userGenerator.validPassword(password)) {
                System.out.println("Please select a password that is valid.");
                return false;
            }
            if (!userGenerator.validBirthdate(year, month, day)){
                System.out.println("Please enter a valid birthdate.");
                return false;
            }
            user = userGenerator.generateUser(username, password, year, month, day);
        }
        try {
            FileOutputStream outFile = new FileOutputStream(username + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(user); //writes the user to "username.ser"
            out.close();
            outFile.close();
            return user;
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return user;
    }
    public static boolean userExists(String username) {
        User existingUser = null;
        try {
            FileInputStream inputStream = new FileInputStream(username + ".ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            existingUser = (User) in.readObject();
            in.close();
            inputStream.close();

        }
        catch (FileNotFoundException ex){
            return false;
        }
        catch(ClassNotFoundException | IOException ioException) {
            ioException.printStackTrace();
        }
        return existingUser != null;
    }
}
