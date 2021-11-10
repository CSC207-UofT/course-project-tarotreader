package useCases;

import entities.Card;
import entities.Deck;
import entities.User;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TarotReader {
    public ArrayList<String> reading;

    public TarotReader(ArrayList<Card> chosenCards) {
        /*this.reading = new ArrayList<>(chosenCards.size());*/
        this.reading = new ArrayList<>();
        System.out.println("You have chosen " + chosenCards.size() + " cards.");
        for (Card c : chosenCards) {
            this.reading.add(c.getMeaning());
        }
    }

    @Override
    public String toString() {
        StringBuilder myString = new StringBuilder();
        String s = "Hey there! Here is your reading for today:\n";
        for (String r : this.reading) {
            myString.append(r);
            myString.append("\n");
        }
        s += myString;
        return s;
    }
    public static ArrayList<Card> shuffler(int n){
        ArrayList<Card> deckClone = (ArrayList<Card>) Deck.getDeck().clone();

        for (int i = 0; i < n; i++) {
            Collections.shuffle(deckClone);
        }
        return deckClone;
    }

    public static ArrayList<Card> cardPicker(ArrayList < Card > shuffledDeck){
        ArrayList<Card> pickedCards = new ArrayList<>();
        Random rand = new Random();
        int index1 = rand.nextInt(78);
        int index2 = rand.nextInt(78);
        int index3 = rand.nextInt(78);

        pickedCards.add(shuffledDeck.get(index1));
        pickedCards.add(shuffledDeck.get(index2));
        pickedCards.add(shuffledDeck.get(index3));
        return pickedCards;
    }

}
