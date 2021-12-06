package useCases;

import controllers.UserGeneratorController;
import entities.User;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Class for generating users

public class UserGenerator {
    /**
     *
     * @param username: username of the User object to generate
     * @param password: password of the User object to generate
     * @param year: birth year of the User object to generate
     * @param month: birth month of the User object to generate
     * @param day: birthday of the User object to generate
     */
    public static void generateUser(String username, String password, int year, int month, int day) {
        /*
        Generates and Serializes the User object. Try to deserialize the User from its filename(username.ser)
         */
        User existingUser = null;
        existingUser = UserGeneratorController.getExistingUser(username);
        if (existingUser != null){
            System.out.println("Username already exists!");
            }
        else if (!validPassword(password)) {
            System.out.println("Please select a password that is valid.");
        }
        else if (!validBirthdate(year, month, day)){
            System.out.println("Please enter a valid birthdate.");
        }
        else{
            User user = new User(username, password, year, month, day); //Creates the User object
            //Tries to serialize the object in this try block
            try {
                FileOutputStream outFile = new FileOutputStream(username + ".ser");
                ObjectOutputStream out = new ObjectOutputStream(outFile);
                out.writeObject(user); //writes the user to "username.ser"
                out.close();
                outFile.close();
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
        }}
    }
    public static boolean validPassword(String password){
        /*
        Enforces a password that is shown by the regex shown below.
        a "valid" password consists of at least one digit, one lowercase letter,
        one uppercase letter, and it needs to be between 8-20 characters without a
        whitespace. Return true iff password matches the pattern.
         */
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
        }

    public static boolean validBirthdate(int year, int month, int day) {
        /*
        Checks if a birthdate is valid.
         */
        if ((year < 1900) | (year > 2021) | (month > 12) | (month < 1) | (day < 1) | (day > 31)) {
            return false;
        } else if (month == 2) {
            if (year % 4 == 0) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if ((month == 4) | (month == 6) | (month == 9) | (month == 11)) {
            return day <= 30;
    } return true;
}
}


