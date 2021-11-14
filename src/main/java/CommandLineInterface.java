import entities.User;
import useCases.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandLineInterface{
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList();
        users.add(new User("bahati", "password", 1999, 7, 9));

        System.out.println("Welcome to Tarot Reader 3000");
        Scanner account = new Scanner(System.in);
        System.out.println("Please enter 1 for logging in or 2 for creating a new account");
        int entry = Integer.parseInt(account.nextLine());
        if(entry == 1)
        {
            // Ask for Username
            String username = account.nextLine();
            // Ask for Password
            String password = account.nextLine();
            // Do Login
            try {
                LogIn.login(username, password, users);
            } catch(Exception e) {
                System.out.println("Error: No Such User Found!");
            }
        } else if(entry == 2)
        {
            // Ask for Username
            System.out.println("Enter Username: ");
            String username = account.nextLine();
            // Ask for Password
            System.out.println("Enter Password: ");
            String password = account.nextLine();
            // Ask for Date of Birth
            System.out.println("Enter Date of Birth");
            String dob = account.nextLine();
            int year = Integer.parseInt(dob.split("-")[0]);
            int month = Integer.parseInt(dob.split("-")[1]);
            int day = Integer.parseInt(dob.split("-")[2]);
            // Generate a User
            UserGenerator.generateUser(username, password, year, month, day);
        }

    }
}