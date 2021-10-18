package entities;

public class Spread {

    private String spreadName;
    private int numberOfCards;
    private String positionMeaning;

    public Spread(String spreadName, String numberOfCards){
        this.spreadName = spreadName;
        this.numberOfCards = Integer.parseInt(numberOfCards);
    }

    public Spread(String spreadName, String numberOfCards, String positionMeaning){
        this.spreadName = spreadName;
        this.numberOfCards = Integer.parseInt(numberOfCards);
        this.positionMeaning = positionMeaning;
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
}