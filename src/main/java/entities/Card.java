package entities;

public class Card{
    /***
     *
     */
    private final String name;
    private int number;
    private boolean isReversed;
    private boolean isMajor;
    private String suit;
    private String meaning;
    public Card(String name, String number,  String isMajor, String meaning){
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.meaning = meaning;
        this.isReversed = false;
    }
    public Card(String name, String number, String isMajor, String suit, String meaning){
        this.name = name;
        this.number = Integer.parseInt(number);
        this.isMajor = Boolean.parseBoolean(isMajor);
        this.suit = suit;
        this.meaning = meaning;
        this.isReversed = false;
    }


    public String getMeaning(){
        return this.meaning;
    }
    public String getName(){
        return this.name;
    }
    public boolean isReversed(){return this.isReversed;}
    public void setReversed(boolean bool){
        this.isReversed = bool;
    }
}

