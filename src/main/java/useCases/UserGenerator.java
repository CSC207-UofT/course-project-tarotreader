package useCases;
import entities.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserGenerator {
    /**
     * Class for generating users.
     * @param username: username of the User object to generate
     * @param password: password of the User object to generate
     * @param year: birth year of the User object to generate
     * @param month: birth month of the User object to generate
     * @param day: birthday of the User object to generate
     */
    public User generateUser(String username, String password, int year, int month, int day) {
        /*
        Generates a User object.
         */
        return new User(username, password, year, month, day);
    }
    public boolean validPassword(String password){
        /*
        Enforces a password that is shown by the regex shown below.
        a "valid" password consists of at least one digit, one lowercase letter,
        one uppercase letter, and it needs to be between 8-20 characters without a
        whitespace. Return true iff password matches the pattern.
         */
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
        }

    public boolean validBirthdate(int year, int month, int day) {
        /*
        Checks if a birthdate is valid.
         */
        if ((year < 1900) | (year > 2021) | (month > 12) | (month < 1) | (day < 1) | (day > 31)) {
            return false;
        } else if (month == 2) {
            if (year % 4 == 0) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if ((month == 4) | (month == 6) | (month == 9) | (month == 11)) {
            return day <= 30;
    } return true;

    }
    public boolean validUsername(String username){
        return username.length() >= 5;
    }
}


