package controllers;

import entities.Card;
import java.util.ArrayList;
import java.util.Random;

public class CardPicker {
    private static ArrayList<Card> pickedCards = new ArrayList<>();
    private static final Random rand = new Random();
    private static final int index1 = rand.nextInt(78);
    private static final int index2 = rand.nextInt(78);
    private static final int index3 = rand.nextInt(78);

    public static ArrayList<Card> getPickedCards(ArrayList<Card> shuffledDeck){
        pickedCards.add(shuffledDeck.get(index1));
        pickedCards.add(shuffledDeck.get(index2));
        pickedCards.add(shuffledDeck.get(index3));
        return pickedCards;
    }

}

