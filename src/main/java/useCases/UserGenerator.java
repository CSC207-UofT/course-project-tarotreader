package useCases;

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
    //Generates and Serializes the User object
    public static void generateUser(String username, String password, int year, int month, int day) {
        //try to deserialize the User from its filename(username.ser)
        User existingUser = null;
        existingUser = getExistingUser(username);
        if (existingUser != null){
            System.out.println("Username already exists!");
            }
        else if (!validPassword(password)) {
            System.out.println("Please select a password that is valid.");
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
    public static boolean validPassword(String password){
        //enforces a password that is shown by the regex shown below.
        // a "valid" password consists of at least one digit, one lowercase letter,
        // one uppercase letter, and it needs to be between 8-20 characters without a
        // whitespace.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        //return true iff password matches the pattern.
        Matcher m = p.matcher(password);
        return m.matches();
        }
    }

