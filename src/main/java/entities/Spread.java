package entities;

import useCases.SpreadInit;

import java.io.IOException;
import java.util.ArrayList;

public class Spread {

    private String spreadName;
    private int numberOfCards;
    private String positionMeaning;

    public Spread(String spreadName, String numberOfCards){
        this.spreadName = spreadName;
        this.numberOfCards = Integer.parseInt(numberOfCards);
    }

    public String getSpreadName(){
        return this.spreadName;
    }

    public int getNumCards(){
        return this.numberOfCards;
    }

    public String getPositionMeanings(){
        return this.positionMeaning;
    }

    public static ArrayList<Spread> getSpreadList() throws IOException { return SpreadInit.getSpreads();}
}

