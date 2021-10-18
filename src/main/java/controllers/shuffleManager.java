package controllers;

import entities.Card;
import useCases.Shuffler;
import java.util.ArrayList;

public class ShuffleManager extends Shuffler {
    public static ArrayList<Card> shuffleNTimes(int n) throws Exception {
        ArrayList<Card> result = new ArrayList<Card>();
        if (n <= 0 || n > 10){
            throw new Exception("Please enter a valid input between 1 and 10");
        }
        return Shuffler.shuffleDeck(n);
    }
}
