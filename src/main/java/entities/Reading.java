package entities;

import entities.Card;
import entities.Deck;
import entities.User;

import java.io.Serializable;
import java.util.ArrayList;


public class Reading implements Serializable {
    public ArrayList<Card> chosenCards;
    public ArrayList<String> reading;
    public String name;
    public Spread spread;
    public String readingname;

    public Reading (ArrayList<Card> pickedCards, User user, Spread spread){
        this.chosenCards = pickedCards;
        this.reading = new ArrayList<>(chosenCards.size());
        this.name = user.username;
        this.spread = spread;
        int i = 0;
        this.readingname = "";
        for (Card c: chosenCards){
            this.reading.set(i, c.getMeaning());
            i ++;
        }
    }
    public void nameReading(String name){
        this.readingname = name;
    }
    @Override
    public String toString(){
        StringBuilder myString = new StringBuilder();
        String s = "Hey " + this.name + "! Here is your reading for today:\n";
        for (String r: this.reading){
            myString.append(r);
            myString.append("\n");
        }
        s += myString;
        return s;
    }
}
