import controllers.UserGeneratorController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
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
    public void testUserExistsForNotExistingUser(){
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        assert !UserGeneratorController.userExists(generatedString);
    }
    @Test
    public void testGenerateUserForExistingUser() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        UserGeneratorController.getInstance().generateUser(generatedString, "Password123", 2001,
                4, 30);
        UserGeneratorController.getInstance().generateUser(generatedString, "Password123", 2001,
                4, 30);
        Assert.assertEquals("Username already exists!", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testGenerateUserForNotExistingUser() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        assert UserGeneratorController.getInstance().generateUser(generatedString, "Password123",
                2001, 4, 30) != null;
    }
    @Test
    public void testGenerateUserInvalidPassword() {
        UserGeneratorController.getInstance().generateUser("userforpasswordtrial", "invalid",
                2001, 4, 30);
        Assert.assertEquals("Please select a password that is valid. A valid password has at least one" +
                "lowercase and one uppercase character, and a digit.", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testGenerateUserInvalidBirthdate() {
        UserGeneratorController.getInstance().generateUser("userforbirthdatetrial", "Password123",
                2101, 4, 30);
        Assert.assertEquals("Please enter a valid birthdate.", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testGenerateUserForInvalidUsername(){
        UserGeneratorController.getInstance().generateUser("a", "Password1", 2001, 4,
                30);
        Assert.assertEquals("Please enter a username that has more than 5 characters.",
                outputStreamCaptor.toString().trim());
    }
    @After
    public void tearDown(){
        System.setOut(standardOut);
    }
}
