package useCases;

import java.util.Random;
import entities.card;
import entities.deck;
import java.util.ArrayList;
import java.util.Collections;

public class shuffler {
    public static ArrayList<card> shuffleDeck(int n) {
        ArrayList<card> deckClone = (ArrayList<card>) deck.getDeck().clone();

        for (int i = 0; i < n; i++) {
            Collections.shuffle(deckClone);
        }
        return deckClone;
    }
}