package entities;

public class spread {

    private String spreadName;
    private int numberOfCards;
    private String positionMeaning;

    public spread(String spreadName, String numberOfCards){
        this.spreadName = spreadName;
        this.numberOfCards = Integer.parseInt(numberOfCards);
    }

    public spread(String spreadName, String numberOfCards, String positionMeaning){
        this.spreadName = spreadName;
        this.numberOfCards = Integer.parseInt(numberOfCards);
        this.positionMeaning = positionMeaning;
    }
}