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
        ArrayList<Card> deckClone = (ArrayList<Card>) Deck.getDeck().clone();
        Random randomBool = new Random();
        for (int i = 0; i < n; i++) {
            Collections.shuffle(deckClone);
            System.out.println("I'm shuffling the deck for you...");
        }
        for(Card card:deckClone){
            card.setReversed(randomBool.nextBoolean());
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

    public static Reading generateReading(User user, Spread spread, int shuffle, ArrayList<Integer> indexOfCards){
        ArrayList<Card> shuffledDeck = shuffleDeck(shuffle);
        ArrayList<Card> pickedCards = pickCard(shuffledDeck, indexOfCards);
        return new Reading(pickedCards, user, spread);
    }
    // Method that enables user to name the readings.
    public void nameReading(String name, Reading reading){
        reading.readingName = name;
    }
}

