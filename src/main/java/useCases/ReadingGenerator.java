package useCases;

import entities.Card;
import entities.Deck;
import entities.User;
import entities.Spread;
import java.sql.Array;
import entities.Reading;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ReadingGenerator {
    public ArrayList<String> reading;

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
    public static ArrayList<Card> pickCard(ArrayList<Card> shuffledDeck, ArrayList<Integer> indexOfCards){
        ArrayList<Card> pickedCards = new ArrayList<>();
        for (int i: indexOfCards){
            pickedCards.add(shuffledDeck.get(i));
        }
        return pickedCards;
    }

    public static Reading generateReading(User user, Spread spread, int shuffle, ArrayList<Integer> indexOfCards){
        ArrayList<Card> shuffledDeck = shuffleDeck(shuffle);
        ArrayList<Card> pickedCards = pickCard(shuffledDeck, indexOfCards);
        return new Reading(pickedCards, user, spread);
    }

}

