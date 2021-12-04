package entities;

import useCases.SpreadInit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Spread {
    private static final String GEN = "General Reading";
    private static final String PPF = "Past Present Future Reading";
    private static final String LOVE = "Love Reading";
    private static final String CAREER = "Career Reading";
    /***
     * Holds constructor and methods for Spread objects
     */

    private final String spreadName;
    private final int numberOfCards;
    private final String requiredMeaningType;

    public Spread(String spreadName, String numberOfCards) throws WrongSpreadType{
        this.spreadName = spreadName;
        this.numberOfCards = Integer.parseInt(numberOfCards);
        if(Objects.equals(spreadName, GEN)){
            this.requiredMeaningType = "General";
        }else if(Objects.equals(spreadName, PPF)){
            this.requiredMeaningType = "General";
        }else if(Objects.equals(spreadName, LOVE)){
            this.requiredMeaningType = "Love";
        }else if(Objects.equals(spreadName, CAREER)){
            this.requiredMeaningType = "Career";
        }else{
            throw new WrongSpreadType("Spread type does not exist. Please try again");
        }
    }

    public String getSpreadName(){
        /* Returns the name of this spread */
        return this.spreadName;
    }

    public int getNumCards(){
        /* Returns the number of cards in this spread */
        return this.numberOfCards;
    }

    public static ArrayList<Spread> getSpreadList() throws IOException, WrongSpreadType {
        /* Returns an array list of all available Spread objects */
        return SpreadInit.getSpreads();
    }
    public static class WrongSpreadType extends Exception {
        public WrongSpreadType (String errorMessage) {super(errorMessage);}
    }
}

