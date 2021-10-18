package useCases;

import entities.Card;
import entities.Deck;
import java.util.ArrayList;
import java.util.Collections;

public class Shuffler {
    public static ArrayList<Card> shuffleDeck(int n) {
        ArrayList<Card> deckClone = (ArrayList<Card>) Deck.getDeck().clone();

        for (int i = 0; i < n; i++) {
            Collections.shuffle(deckClone);
        }
        return deckClone;
    }
}
