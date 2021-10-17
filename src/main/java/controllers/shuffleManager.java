package controllers;

import entities.card;
import useCases.shuffler;
import java.util.ArrayList;

public class shuffleManager extends shuffler{
    public static ArrayList<card> shuffleNTimes(int n) throws Exception {
        ArrayList<card> result = new ArrayList<card>();
        if (n <= 0 || n > 10){
            throw new Exception("Please enter a valid input between 1 and 10");
        }
        return shuffler.shuffleDeck(n);
    }
}
