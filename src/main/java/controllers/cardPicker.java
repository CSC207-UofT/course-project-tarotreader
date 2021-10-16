package controllers;

import entities.card;
import useCases.shuffler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class cardPicker {

    private static final ArrayList<card> shuffledDeck = shuffler.shuffleDeck();
    private static ArrayList<card> pickedCards = new ArrayList<>();
    private static final Random rand = new Random();
    private static final int index1 = rand.nextInt(78);
    private static final int index2 = rand.nextInt(78);
    private static final int index3 = rand.nextInt(78);

    public static ArrayList<card> getPickedCards(){
        pickedCards.add(shuffledDeck.get(index1));
        pickedCards.add(shuffledDeck.get(index2));
        pickedCards.add(shuffledDeck.get(index3));
        return pickedCards;
    }

}
