package entities;
import useCases.CardInit;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
    //this holds an arraylist of card objects
    private ArrayList<Card> cardList;

    public Deck() {
        this.cardList = new ArrayList<Card>();

    }

    public Deck(ArrayList<Card> cardList) {
        this.cardList = new ArrayList<Card>();
        this.cardList.addAll(cardList);
    }
}

