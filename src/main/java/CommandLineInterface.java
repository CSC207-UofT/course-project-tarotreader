
import controllers.*;

import useCases.ReadingLogActions;

import entities.*;
import useCases.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
//This class is to run the program on the command line
public class CommandLineInterface{

    private static final String LOG_IN = "1";
    private static final String CREATE_USER = "2";
    private static final String EXIT = "q";
    private static final String CONFIRM = "Y";
    private static final String REJECT = "N";
    private static final String LIST_CARDS = "ls";
    private static final String HELP = "help";
    private static final String CARD_LOOKUP = "s";
    private static final String NEW_READING = "nr";

    public static void main(String[] args) {
        //Will continue to loop until user presses "q"
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String input = welcomeUser(scanner);
            //Exit condition
            if (Objects.equals(input, EXIT)) {
                return;
            }
            //Creates new user
            if (Objects.equals(input, CREATE_USER))
            {
                userCreation(scanner);
            }

            else if (Objects.equals(input, LOG_IN))
            {
                User userLoggedIn = doLogin(scanner);
                // Do Login
                // Try login
                // Call getCardList() to get the card list
                while (true) {
                    System.out.println("Please enter a command. Type 'help' for a list of commands");
                    String in = scanner.nextLine();
                    ArrayList<Card> cardList = new ArrayList<>();
                    try {
                        cardList = CardInit.getCardList();
                    }
                    catch (IOException ioException) {
                        System.out.println("Something went wrong... Please try again");
                        break;
                    }
                    // Ask for Spread
                    ArrayList<Spread> spreads = new ArrayList<>();
                    try {
                        spreads = SpreadInit.getSpreads();
                    }
                    catch (IOException | Spread.WrongSpreadType ioException) {
                        System.out.println("Something went wrong... Please try again");
                        break;
                    }
                    if (in.equals(NEW_READING)) {
                        newReading(scanner, userLoggedIn, cardList, spreads);
                    }
                    if (in.equals(LIST_CARDS)) {
                        listCards();

                    }
                    if (in.equals(CARD_LOOKUP)) {
                        System.out.println("Please enter a keyword");
                        String query = scanner.nextLine();
                        CardLookupController cardLookupController = new CardLookupController();
                        System.out.println(cardLookupController.searchCard(query));
                    }
                    if (in.equals(HELP)) {
                        help();
                    }
                    if (in.equals(EXIT)) {
                        break;
                    }

                }
            }

        }

    }

    private static void listCards() {
        CardLookupController cardLookupController = new CardLookupController();
        System.out.println(cardLookupController.getCardList());
    }

    private static void newReading(Scanner scanner, User userLoggedIn, ArrayList<Card> cardList, ArrayList<Spread> spreads) {
        int spreadNumChosen = getSpreadNumChosen(spreads, scanner);
        // Ask for number of times to shuffle
        ArrayList<Card> shuffledDeck = getShuffledDeck(scanner);
        // Allow user to select 3 cards
        ArrayList<Integer> indicesChosen = pickCardIndices(cardList, scanner);
        Reading theReading = getGeneratedReading(userLoggedIn, spreads, spreadNumChosen, shuffledDeck, indicesChosen);
        // Present the Reading to the User
        System.out.println(theReading.toString());
        logReadingToReadingLog(userLoggedIn, theReading, scanner);
        viewReadingLog(userLoggedIn, scanner);
    }

    private static void viewReadingLog(User userLoggedIn, Scanner account) {
        System.out.println("Would you like to view your reading log? Type " + CONFIRM + " for yes and " + REJECT + " for no:");
        String viewLog = account.nextLine();
        if (Objects.equals(viewLog, CONFIRM)){
            ReadingLogManager readingLogManager = new ReadingLogManager(userLoggedIn);
            System.out.println(readingLogManager.viewReadingLog());
        }
    }

    private static void logReadingToReadingLog(User userLoggedIn, Reading reading, Scanner account) {
        System.out.println("Would you like to log this reading? Type " + CONFIRM + " for yes and " + REJECT + " for no:");
        String log = account.nextLine();
        if(Objects.equals(log, CONFIRM)){
            System.out.println("Please name your reading");
            String readingName = account.nextLine();
            ReadingLogManager readingLogManager = new ReadingLogManager(userLoggedIn);
            readingLogManager.logReading(reading, readingName);
            UserManager.updateUser(userLoggedIn);
        }
    }

    private static Reading getGeneratedReading(User userLoggedIn, ArrayList<Spread> spreads, int spreadNumChosen, ArrayList<Card> shuffledDeck, ArrayList<Integer> indicesChosen) {
        Spread spread = spreads.get(spreadNumChosen);
        // Generate Reading
        return ReadingGenerator.generateReading(userLoggedIn, spread, shuffledDeck, indicesChosen); //Do this using reading generator controller
    }

    private static ArrayList<Integer> pickCardIndices(ArrayList<Card> cardList, Scanner account) {
        ArrayList<Integer> indicesChosen = new ArrayList<>();
        System.out.println("There are " + cardList.size() + " cards");
        for(int i = 0;i<3;i++) {
            System.out.println("Please select card #" + (i + 1) + ": ");
            indicesChosen.add(Integer.parseInt(account.nextLine()));
        }
        return indicesChosen;
    }

    private static ArrayList<Card> getShuffledDeck(Scanner account) {
        System.out.println("How many times do you want to shuffle?");
        int shuffleCount = Integer.parseInt(account.nextLine());
        ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(shuffleCount);
        return shuffledDeck;
    }

    private static int getSpreadNumChosen(ArrayList<Spread> spreads, Scanner account) {
        System.out.println("Size of spreads is " + spreads.size());
        System.out.println("What spread do you want?");
        for(int i = 0; i< spreads.size(); i++)
        {
            System.out.println(i + " " + spreads.get(i).getSpreadName());
        }
        int spreadNumChosen = Integer.parseInt(account.nextLine());
        String spreadName = spreads.get(spreadNumChosen).getSpreadName();
        return spreadNumChosen;
    }

    private static User doLogin(Scanner account) {
        boolean isValidUserInfo = false;
        User userLoggedIn = null;
        while (!isValidUserInfo) {
            System.out.println("Enter username:");
            String username = account.nextLine();
            quitRequested(username);
            //Ask for Password
            System.out.println("Enter password:");
            String password = account.nextLine();
            quitRequested(password);
            userLoggedIn = (User) LoginController.getInstance().login(username, password);
            boolean isSuccess = userLoggedIn instanceof User; //Ignore the warning, want to see if the value is a boolean or User
            if (isSuccess) isValidUserInfo = true;
        }
        return userLoggedIn;
    }

    private static void userCreation(Scanner account) {
        boolean isValidUserInfo = false;
        var input = "";
        while (!isValidUserInfo) {
            // Ask for Username
            System.out.println("Enter Username: ");
            String username = account.nextLine();
            quitRequested(username);
            // Ask for Password
            System.out.println("Enter Password: ");
            String password = account.nextLine();
            quitRequested(password);

            // Ask for Date of Birth
            System.out.println("Enter day of birth");
            String dob = account.nextLine();
            quitRequested(dob);

            int day = Integer.parseInt(dob);
            System.out.println("Enter month of birth");
            String mob = account.nextLine();
            quitRequested(mob);
            int month = Integer.parseInt(mob);
            System.out.println("Enter year of birth");
            String yob = account.nextLine();
            quitRequested(yob);
            int year = Integer.parseInt(yob);

            // Generate a User
            var user = UserGeneratorController.getInstance().generateUser(username, password, year, month, day);
            boolean isSuccess = user instanceof User;
            if (isSuccess) isValidUserInfo = true;
        }
        System.out.println("User created. Redirecting to login...");
    }

    private static String welcomeUser(Scanner scanner) {
        System.out.println("Welcome to Tarot Reader 3000");
        System.out.println("Please enter " + LOG_IN + " for logging in or " + CREATE_USER + " for creating a new account");
        System.out.println("Or press " + EXIT + " to quit");
        return scanner.nextLine();
    }

    private static void quitRequested(String input) {
        if (input.equals(EXIT)) {
            System.exit(0);
        }
    }

    private static void help() {
        System.out.println("Here is the list of commands: \n q: quits the program\n ls: lists all cards\n" +
                "s: lookup cards with a keyword search\n nr: creates new reading");
    }

}
