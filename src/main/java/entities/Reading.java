package entities;

import java.io.Serializable;
import java.util.ArrayList;


public class Reading implements Serializable {
    /* Reading is an entity object that holds the information about the reading itself.
     *readingName: Name of the reading generated. Will be used in phase2.
     *chosenCards: Keeps the list of Cards that was picked by the user.
     *reading: Keeps the meaning of the cards as a list of strings. When toString method is called upon the object, it
     * prints the reading in a way that user can understand.
     * name: Name of the user.
     * spread: holds the Spread object chosen by the user. Spread affects the way that reading is printed for the user.
     */
    public String readingName;
    public ArrayList<String> reading;
    public String name;
    //public Spread spread;
    private String spreadName;


    public Reading (User user, Spread spread){
        this.reading = new ArrayList<>();
        this.name = user.username;
        //this.spread = spread;
        this.readingName = "";
        this.spreadName = spread.getSpreadName();
    }
    /*toString method that prints out the reading according to the spread chosen by the user and in a way that user can
    understand easily.
     */

    public void addCardMeanings(ArrayList<Card> pickedCards) {
        for (Card c: pickedCards){
            this.reading.add(c.getMeaning());
        }
    }

    public void setReadingName(String name) {
        this.readingName = name;
    }


    @Override
    public String toString(){
        StringBuilder myString = new StringBuilder();
        String s = "Hey " + this.name + "! You have chosen the " + spreadName + ". Here is your reading for today...\n";

        switch (spreadName) {
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
