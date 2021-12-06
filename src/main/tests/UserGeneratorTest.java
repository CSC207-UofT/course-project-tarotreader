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
    public void testValidBirthdateForInvalidYear(){
        Assert.assertFalse(UserGenerator.validBirthdate(2111, 4, 30));
    }
    @Test
    public void testValidBirthdateForInvalidMonth(){
        Assert.assertFalse(UserGenerator.validBirthdate(2011, 13, 30));
    }
    @Test
    public void testValidBirthdateForInvalidDate(){
        Assert.assertFalse(UserGenerator.validBirthdate(2001, 4, 33));
    }
    @Test
    public void testValidBirthdateForFebruary(){
        Assert.assertFalse(UserGenerator.validBirthdate(2021, 2, 31));
    }
    @Test
    public void testValidBirthdateForFebruary28(){
        Assert.assertFalse(UserGenerator.validBirthdate(2021, 2, 29));
    }
    @Test
    public void testValidBirthdateForFebruary29(){
        Assert.assertFalse(UserGenerator.validBirthdate(2019, 2, 29));
    }
    @Test
    public void testValidBirthdateForMonthsWith30Days(){
        Assert.assertFalse(UserGenerator.validBirthdate(2020, 11, 31));
    }
    @After
    public void tearDown(){
        System.setOut(standardOut);
    }
}

