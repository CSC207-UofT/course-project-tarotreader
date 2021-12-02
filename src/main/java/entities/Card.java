package entities;

import java.util.Objects;

public class Card{
    /***
     * Holds constructors and methods for Major and Minor Card objects
     */
    private final String name;
    private int number;
    private boolean isReversed;
    private boolean isMajor;
    private String suit;
    private String generalMeaning;
    private String loveMeaning;
    private String careerMeaning;
    public Card(String name, String number,  String isMajor, String generalMeaning, String loveMeaning, String careerMeaning){
        /* Constructor for Major Arcana Card objects*/
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.generalMeaning = generalMeaning;
        this.loveMeaning = loveMeaning;
        this.careerMeaning = careerMeaning;
        this.isReversed = false;
    }
    public Card(String name, String number, String isMajor, String suit, String generalMeaning, String loveMeaning, String careerMeaning){
        /* Constructor for Minor Arcana Card objects*/
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.suit = suit;
        this.generalMeaning = generalMeaning;
        this.loveMeaning = loveMeaning;
        this.careerMeaning = careerMeaning;
        this.isReversed = false;
    }

    public String getMeaning(String meaningType){
        /* Returns the meaning for this card */
        if(Objects.equals(meaningType, "General")){
            return this.generalMeaning;
        }else if(Objects.equals(meaningType, "Love")){
            return this.loveMeaning;
        }else {
            return this.careerMeaning;
        }
    }
    public String getName(){
        /* Returns the name for this card */
        return this.name;
    }
    public boolean isReversed(){
        /* Returns True iff this card position is reversed */
        return this.isReversed;
    }

    public void setReversed(boolean bool){
        /* Sets the isReversed value for this card */
        this.isReversed = bool;
    }

    public int getNumber() {
        return this.number;
    }

    /**
     *
     * @return return a string representation of this card object
     */
    @Override
    public String toString() {
        //Ternary operator to determine whether the header should write Major or Minor based on the value of isMajor
        String majorOrMinor = isMajor ? "(Major)" : "(Minor)";
        return getName() + " " + majorOrMinor + "\n" + suit + "\n" + "General Meaning: " +
                getMeaning("General") + "\n" + "Love Meaning: " + getMeaning("Love") + "\n" +
                "Career Meaning: " + getMeaning("Career");
    }
}

