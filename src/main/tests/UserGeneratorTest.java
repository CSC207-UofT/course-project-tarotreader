import org.junit.Assert;
import useCases.UserGenerator;
import org.junit.Test;
public class UserGeneratorTest {
    public UserGeneratorTest(){

    }
    @Test
    public void testValidPasswordForInvalidPassword(){
        UserGenerator userGenerator = new UserGenerator();
        assert(!userGenerator.validPassword("invalid:)"));
    }
    @Test
    public void testValidPasswordForValidPassword(){
        UserGenerator userGenerator = new UserGenerator();
        assert(userGenerator.validPassword("Validpassword1"));
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
    @Test
    public void testValidUsernameForInvalidUsername(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertFalse(userGenerator.validUsername("e"));
    }
    @Test
    public void testValidUsernameForValidUsername(){
        UserGenerator userGenerator = new UserGenerator();
        Assert.assertTrue(userGenerator.validUsername("eliferzincan"));
    }
}

