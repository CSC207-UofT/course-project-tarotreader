package entities;

import entities.Card;
import entities.Deck;
import entities.User;

import java.io.Serializable;
import java.util.ArrayList;


public class Reading implements Serializable {
    public String readingName;
    public ArrayList<Card> chosenCards;
    public ArrayList<String> reading;
    public String name;
    public Spread spread;


    public Reading (ArrayList<Card> pickedCards, User user, Spread spread){
        this.chosenCards = pickedCards;
        this.reading = new ArrayList<>(chosenCards.size());
        this.name = user.username;
        this.spread = spread;
        this.readingName = "";
        int i = 0;
        for (Card c: chosenCards){
            this.reading.set(i, c.getMeaning());
            i ++;
        }
    }

    @Override
    public String toString(){
        StringBuilder myString = new StringBuilder();
        String s = "Hey " + this.name + "! You have chosen the " + spread.getSpreadName() + ". Here is your reading for today...\n";

        switch (spread.getSpreadName()) {
            case "Past Present Future Reading": {
                int i = 0;
                for (String r : this.reading) {
                    if (i == 0) {
                        myString.append("Past:");
                        myString.append("\n");
                    } else if (i == 1) {
                        myString.append("Present:");
                        myString.append("\n");
                    } else {
                        myString.append("Future");
                        myString.append("\n");
                    }
                    myString.append(r);
                    myString.append("\n");
                    i++;
                }
                break;
            }
            case "Love Reading": {
                int i = 0;
                for (String r : this.reading) {
                    if (i == 0) {
                        myString.append("You:");
                        myString.append("\n");
                    } else if (i == 1) {
                        myString.append("Dynamic:");
                        myString.append("\n");
                    } else {
                        myString.append("Lover:");
                        myString.append("\n");
                    }
                    myString.append(r);
                    myString.append("\n");
                    i++;
                }
                break;
            }
            case "Career Reading": {
                int i = 0;
                for (String r : this.reading) {
                    if (i == 0) {
                        myString.append("You:");
                        myString.append("\n");
                    } else if (i == 1) {
                        myString.append("Your Path:");
                        myString.append("\n");
                    } else {
                        myString.append("Potential:");
                        myString.append("\n");
                    }
                    myString.append(r);
                    myString.append("\n");
                    i++;
                }
                break;
            }
            default:
                for (String r : this.reading) {
                    myString.append(r);
                    myString.append("\n");
                }
                break;
        }

        s += myString;
        return s;
    }

}
