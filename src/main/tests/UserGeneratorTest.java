import controllers.UserGeneratorController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import useCases.UserGenerator;
import org.junit.Test;
import java.io.*;
public class UserGeneratorTest {
    public UserGeneratorTest(){

    }
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testGenerateExistingUser() {
        UserGeneratorController.getInstance().generateUser("eliferzincan", "Password123", 2001, 4, 30);
        Assert.assertEquals("Username already exists!", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    public void testValidBirthdateForInvalidYear(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validBirthdate(2111, 4, 30));
    }
    @Test
    public void testValidBirthdateForInvalidMonth(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validBirthdate(2011, 13, 30));
    }
    @Test
    public void testValidBirthdateForInvalidDate(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validBirthdate(2001, 4, 33));
    }
    @Test
    public void testValidBirthdateForFebruary(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validBirthdate(2021, 2, 31));
    }
    @Test
    public void testValidBirthdateForFebruary28(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validBirthdate(2021, 2, 29));
    }
    @Test
    public void testValidBirthdateForFebruary29(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validBirthdate(2019, 2, 29));
    }
    @Test
    public void testValidBirthdateForMonthsWith30Days(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validBirthdate(2020, 11, 31));
    }
    @After
    public void tearDown(){
        System.setOut(standardOut);
    }
}

