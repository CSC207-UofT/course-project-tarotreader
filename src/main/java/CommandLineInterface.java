import entities.Card;
import entities.Reading;
import entities.Spread;
import entities.User;
import useCases.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
//This class is to run the program on the command line
public class CommandLineInterface{
    public static void main(String[] args) {
        //Will continue to loop until user presses "q"
        while (true) {
            System.out.println("Welcome to Tarot Reader 3000");
            Scanner account = new Scanner(System.in);
            System.out.println("Please enter 1 for logging in or 2 for creating a new account");
            System.out.println("Or press q to exit");
            String input = account.nextLine();
            //Exit condition
            if (Objects.equals(input, "q")) {
                return;
            }
            int entry = Integer.parseInt(input);
            //Creates new user
            if (entry == 2)
            {
                // Ask for Username
                System.out.println("Enter Username: ");
                String username = account.nextLine();
                // Ask for Password
                System.out.println("Enter Password: ");
                String password = account.nextLine();
                // Ask for Date of Birth
                System.out.println("Enter day of birth");
                String dob = account.nextLine();
                int day = Integer.parseInt(dob);
                System.out.println("Enter month of birth");
                String mob = account.nextLine();
                int month = Integer.parseInt(mob);
                System.out.println("Enter year of birth");
                String yob = account.nextLine();
                int year = Integer.parseInt(yob);

                // Generate a User
                UserGenerator.generateUser(username, password, year, month, day);
                System.out.println("User created. Redirecting to login...");
            }
            else if (entry == 1)
            {
                // Ask for Username
                System.out.println("Enter username:");
                String username = account.nextLine();
                // Ask for Password
                System.out.println("Enter password:");
                String password = account.nextLine();
                // Do Login
                try {
                    // Try login
                    User userLoggedIn = LogIn.login(username, password);
                    // Call getCardList() to get the card list
                    ArrayList<Card> cardList = CardInit.getCardList();
                    // Ask for Spread
                    ArrayList<Spread> spreads = SpreadInit.getSpreads();
                    System.out.println("Size of spreads is " + spreads.size());
                    System.out.println("What spread do you want?");
                    for(int i = 0;i<spreads.size();i++)
                    {
                        System.out.println(i + " " + spreads.get(i).getSpreadName());
                    }
                    int spreadNumChosen = Integer.parseInt(account.nextLine());
                    String spreadName = spreads.get(spreadNumChosen).getSpreadName();
                    // Ask for number of times to shuffle
                    System.out.println("How many times do you want to shuffle?");
                    int shuffleCount = Integer.parseInt(account.nextLine());
                    ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(shuffleCount);
                    // Allow user to select 3 cards
                    ArrayList<Integer> indicesChosen = new ArrayList<>();
                    System.out.println("There are " + cardList.size() + " cards");
                    for(int i = 0;i<3;i++) {
                        System.out.println("Please select card #" + (i + 1) + ": ");
                        indicesChosen.add(Integer.parseInt(account.nextLine()));
                    }
                    //System.out.println("Enter Number of Cards: ");
                    //String numOfCards = account.nextLine();
                    //Spread spread = new Spread(spreadName, numOfCards);
                    Spread spread = spreads.get(spreadNumChosen);
                    // Generate Reading
                    Reading theReading = ReadingGenerator.generateReading(userLoggedIn, spread, shuffledDeck, indicesChosen);
                    // Instantiate a ReadingLogger
                    ReadingLogger readingLogger = new ReadingLogger(userLoggedIn);
                    // Add reading to the ReadingLogger
                    readingLogger.logReading(theReading);
                    // Present the Reading to the User
                    System.out.println(theReading.toString());

                } catch(Exception e) {
                    System.out.println(e);
                }
            }
        }


    }
}