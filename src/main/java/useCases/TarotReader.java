package useCases;

import entities.Card;
import entities.User;

import java.sql.Array;
import java.util.ArrayList;

public class TarotReader {
    public ArrayList<String> reading;
    public TarotReader(ArrayList<Card> chosenCards){
        /*this.reading = new ArrayList<>(chosenCards.size());*/
        this.reading = new ArrayList<>();
        System.out.println("You have chosen " + chosenCards.size() + " cards.");
        for (Card c: chosenCards){
            this.reading.add(c.getMeaning());
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
