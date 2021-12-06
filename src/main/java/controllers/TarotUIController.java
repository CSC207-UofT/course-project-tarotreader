package controllers;
import UI.PopupDisplay;
import UI.TarotCardLayout;
import UI.Frame;
import entities.Card;
import entities.Reading;

import java.util.ArrayList;

public class TarotUIController {
    private Frame appFrame;
    private PopupDisplay display;
    private ArrayList<Card> pickedCards;
    private TarotCardLayout layout;
    public Reading reading;
    public Card card;

    /**
     * initializes certain values as well as activate them
     */
    public TarotUIController(Reading reading)
    {
        this.reading = reading;
        System.out.println("bencaudd");
        display = new PopupDisplay();
        System.out.println("bencauddddd2");
        layout = new TarotCardLayout(this);

    }

    public void start()
    {
        createDeck();
    }

    /**
     * When an error is triggered, it will display error text to the console
     * @param error - gets an error from the program when needed
     */
    public void handleErrors(Exception error)
    {
        display.displayText(error.getMessage());
    }

    /**
     * Recreates a deck after clearing arrays out by calling multiple methods
     */
    public String createDeck()
    {
        return "yarrakkkkkkkk";
    }

    /**
     * Returns the information gained from the cards
     * @return - returns the info from what's been done
     */
    public ArrayList<Card> getMyCards()
    {
        return pickedCards;
    }

}


