import controllers.UserGeneratorController;
import entities.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import controllers.UserGeneratorController;
import useCases.UserGenerator;

public class UserGeneratorControllerTest {
    public UserGeneratorControllerTest(){
    }
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testGetExistingUserForExistingUser(){
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.generateUser("eliferzincan", "Password123", 2001, 4, 30);
        assert UserGeneratorController.userExists("eliferzincan");
    }
    @Test
    public void testGenerateUserForNotExistingUser(){
        assert UserGeneratorController.userExists("doesnotexist") == false;
    }
    @Test
    public void testGenerateExistingUser() {
        UserGenerator userGenerator = new UserGenerator();
        userGenerator.generateUser("eliferzincan", "Password123", 2001, 4, 30);
        Assert.assertEquals("Username already exists!", outputStreamCaptor.toString()
                .trim());
    }
    @After
    public void tearDown(){
        System.setOut(standardOut);
    }
}
