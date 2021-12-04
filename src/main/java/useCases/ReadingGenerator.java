package useCases;

import entities.Card;
import entities.Deck;
import entities.User;
import entities.Spread;
import entities.Reading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/* Reading generator is the class that includes the essential methods that creates the reading for the user. Command
line interface mainly interacts with the methods here to generate the reading.
 */
public class ReadingGenerator {
    //Shuffling method that shuffles the cards in the deck 'n' times according to the number given by the user.
    public static ArrayList<Card> shuffleDeck(int n){
        ArrayList<Card> deckClone = (ArrayList<Card>) Deck.getDeck().clone();       // Create clone of deck so original
                                                                                    // deck does not get mutated
        Random randomBool = new Random();       // Create random object
        for (int i = 0; i < n; i++) {           // Shuffle the deck user input amount of times
            Collections.shuffle(deckClone);
            System.out.println("I'm shuffling the deck for you...");
        }
        for(Card card:deckClone){               // Iterate through deckClone
            card.setReversed(randomBool.nextBoolean());     // Call setReversed on card object and use random bool
        }
        return deckClone;
    }
    //Method that enables user to pick cards from the shuffled deck.
    public static ArrayList<Card> pickCard(ArrayList<Card> shuffledDeck, ArrayList<Integer> indexOfCards){
        ArrayList<Card> pickedCards = new ArrayList<>();
        for (int i: indexOfCards){
            pickedCards.add(shuffledDeck.get(i));
        }
        return pickedCards;
    }
    /*Method that generates the final reading according the picked cards and spread. In the future, we want to further
    develop this method so that it will generate readings by taking into consideration the birthdate, gender, etc. of
    the user.
     */

    public static Reading generateReading(User user, Spread spread, ArrayList<Card> shuffledDeck, ArrayList<Integer> indexOfCards){
        //ArrayList<Card> shuffledDeck = shuffleDeck(shuffle);
        ArrayList<Card> pickedCards = pickCard(shuffledDeck, indexOfCards);
        var newReading = new Reading(user, spread);
        newReading.addCardMeanings(pickedCards);
        newReading.setReadingName(user.getUsername() + user.getReadingLog().getReadings().size());
        return newReading;
    }
    // Method that enables user to name the readings.
    public void nameReading(String name, Reading reading){
        reading.readingName = name;
    }
}

