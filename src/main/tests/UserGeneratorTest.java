import entities.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import useCases.UserGenerator;
import org.junit.Test;
import java.io.*;
public class UserGeneratorTest {
    public UserGeneratorTest() throws IOException{

    }
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testGenerateExistingUser() {
        UserGenerator.generateUser("eliferzincan", "password", 2001, 4, 30);
        Assert.assertEquals("Username already exists!", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testGetExistingUserForExistingUser(){
        assert UserGenerator.getExistingUser("eliferzincan") != null;
    }
    @Test
    public void testGetExistingUserForNotExistingUser(){
        assert UserGenerator.getExistingUser("hahadoesnotexist") == null;
    }
    @Test
    public void testGenerateUserForNotExistingUser(){
        UserGenerator.generateUser("hahadoesnotexist", "password", 2001, 4, 30);
        assert UserGenerator.getExistingUser("hahadoesnotexist") != null;
    }
    @After
    public void tearDown(){
        System.setOut(standardOut);
    }
}

