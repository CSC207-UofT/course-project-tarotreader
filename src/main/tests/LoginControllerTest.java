import controllers.LoginController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    @Test
    public void getInstance(){
        Object firstInstance = LoginController.getInstance();
        Object secondInstance = LoginController.getInstance();
        assertEquals(firstInstance, secondInstance);
    }

    @Test
    public void testLogin() {
        String user = "firstUser";
        String password = "myPassword";
        Object loggedIn = LoginController.getInstance().login(user, password);
        assertFalse((Boolean) loggedIn);
        assertNotEquals(true, loggedIn);
    }

    @Test public void testLoginSuccess()
    {
        String user = "Bahati";
        String password = "Damien";
        Object loggedIn = LoginController.getInstance().login(user, password);
        assertTrue((Boolean) loggedIn);
    }
}