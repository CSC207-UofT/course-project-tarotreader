package useCases;

import entities.User;

import java.io.*;

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
        if (existingUser == null){
            System.out.println("Username already exists!");
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
    private static User getExistingUser(String username) {
        User existingUser = null;
        try {
            FileInputStream inputStream = new FileInputStream(username + ".ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            existingUser = (User) in.readObject();
            in.close();
            inputStream.close();
        }
        catch(ClassNotFoundException | IOException ioException) {
            ioException.printStackTrace();
            }
        return existingUser;
    }
}
