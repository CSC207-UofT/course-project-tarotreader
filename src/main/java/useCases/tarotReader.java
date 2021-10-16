package useCases;

import java.util.ArrayList;

public class tarotReader extends card{
    public ArrayList<card> chosenCards;
    public ArrayList<String> reading;
    public tarotReader(ArrayList<card> chosenCards){
        this.chosenCards = chosenCards;
        this.reading = new ArrayList<>(chosenCards.size());
        int i = 0;
        for (card c: chosenCards){
            this.reading.set(i, c.getMeaning);
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