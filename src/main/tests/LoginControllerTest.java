import controllers.LoginController;
import controllers.UserGeneratorController;
import entities.User;
import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    @Test
    public void getInstance(){
        Object firstInstance = LoginController.getInstance();
        Object secondInstance = LoginController.getInstance();
        assertEquals(firstInstance, secondInstance);
    }


    @Test public void testLoginSuccess()
    {
        File temporary = new File("Bahati.ser");
        if (!temporary.exists()) {
            UserGeneratorController.getInstance().generateUser("Bahati", "Damien12",
                    2001, 1, 1);
        }
        String user = "Bahati";
        String password = "Damien12";
        Object loggedIn = LoginController.getInstance().login(user, password);
        assertTrue(loggedIn instanceof User);
    }
}