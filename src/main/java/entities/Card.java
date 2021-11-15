package entities;

public class Card{
    /***
     * Holds constructors and methods for Major and Minor Card objects
     */
    private final String name;
    private int number;
    private boolean isReversed;
    private boolean isMajor;
    private String suit;
    private String meaning;
    public Card(String name, String number,  String isMajor, String meaning){
        /* Constructor for Major Arcana Card objects*/
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.meaning = meaning;
        this.isReversed = false;
    }
    public Card(String name, String number, String isMajor, String suit, String meaning){
        /* Constructor for Minor Arcana Card objects*/
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.suit = suit;
        this.meaning = meaning;
        this.isReversed = false;
    }


    public String getMeaning(){
        /* Returns the meaning for this card */
        return this.meaning;
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
}

