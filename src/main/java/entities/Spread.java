package entities;

import useCases.SpreadInit;

import java.io.IOException;
import java.util.ArrayList;

public class Spread {
    /***
     * Holds constructor and methods for Spread objects
     */

    private String spreadName;
    private int numberOfCards;

    public Spread(String spreadName, String numberOfCards){
        this.spreadName = spreadName;
        this.numberOfCards = Integer.parseInt(numberOfCards);
    }

    public String getSpreadName(){
        /* Returns the name of this spread */
        return this.spreadName;
    }

    public int getNumCards(){
        /* Returns the number of cards in this spread */
        return this.numberOfCards;
    }

    public static ArrayList<Spread> getSpreadList() throws IOException {
        /* Returns an array list of all available Spread objects */
        return SpreadInit.getSpreads();
    }
}

