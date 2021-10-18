package useCases;

import entities.Card;
import java.util.ArrayList;
import controllers.CardPicker;

public class TarotReader {
    public ArrayList<Card> chosenCards;
    public ArrayList<String> reading;
    public TarotReader(){
        this.chosenCards = CardPicker.getPickedCards();
        this.reading = new ArrayList<>(chosenCards.size());
        int i = 0;
        for (Card c: chosenCards){
            this.reading.set(i, c.getMeaning());
            i ++;
        }
    }
    @Override
    public String toString(){
        StringBuilder myString = new StringBuilder();
        String s = "Hey there! Here is your reading for today:\n";
        for (String r: this.reading){
            myString.append(r);
            myString.append("\n");
        }
        s += myString;
        return s;
    }
}
