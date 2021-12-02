package entities;
import useCases.CardInit;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
    /***
     * Deck object, holds array list of Card objects
     */
    public static ArrayList<Card> cardList;


    static {
        try {
            ArrayList<Card> cardsToAdd = CardInit.getCardList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAll(ArrayList<Card> cardsToAdd){
        cardList.addAll(cardsToAdd);
    }

    public static ArrayList<Card> getDeck(){
        return cardList;
    }
}
