package controllers;

import useCases.LogIn;

public class LoginController {

    private static final LoginController controllerInstance = new LoginController();
    private LogIn logIn;

    private LoginController() {
        // Private constructor so that client-side cannot instantiate this singleton
    }

    public static LoginController getInstance() {
        return controllerInstance;
    }

    public Object login(String username, String password) {
        logIn = new LogIn(username, password);
        try {
            return logIn.login();
        }
        catch (Exception e) {
            return false;
        }
    }

}
