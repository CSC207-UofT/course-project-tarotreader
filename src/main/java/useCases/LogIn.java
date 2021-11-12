package useCases;

import java.util.ArrayList;
import java.util.Objects;

import entities.User;

public class LogIn {

     // Need access to the list of users, don't know where from
    public static User login(String username, String password, ArrayList<User> users) throws NoSuchUserException {
        User loggedInUser = new User("user","123",2001,1, 1);
        boolean foundUser = false;
        for (int i = 0; i < users.size(); i++) {
            String currentUsername = users.get(i).getUsername();
            //String currentPassword = users.get(i).getPassword();
            if (Objects.equals(users.get(i).getUsername(), username)) {
                //TODO: Add password check here
                loggedInUser = users.get(i); //This will be in the password check if
                foundUser = true;
            }
        }
        if (foundUser) {
            return loggedInUser;
        }
        else {
            throw new NoSuchUserException("No user found with username " + username);
        }
    }

    private static class NoSuchUserException extends Exception {
        public NoSuchUserException(String errorMessage) {
            super(errorMessage);
        }
    }
}
