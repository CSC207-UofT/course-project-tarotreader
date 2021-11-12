import useCases.*;

import java.util.Objects;
import java.util.Scanner;

public class CommandLineInterface{
    public static void main(String[] args) {
        System.out.println("Welcome to Tarot Reader 3000");
        Scanner account = new Scanner(System.in);
        System.out.println("Please enter 1 for logging in or 2 for creating a new account");
        String entry = account.nextLine();
        //if (Objects.equals(entry, "1")){
        //    UserGenerator.generate();
        //}
    }
}