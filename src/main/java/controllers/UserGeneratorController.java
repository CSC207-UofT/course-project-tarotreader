package controllers;

import useCases.UserGenerator;

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
}