import entities.Deck;
import org.junit.Test;
import entities.Card;
import useCases.CardInit;


import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

public class DeckTest {

    public DeckTest() throws IOException {
    }

    @Test
    public void TestInitialCardListContents(){
        try {
            ArrayList<Card> thisDeck = Deck.getDeck();
            String output = thisDeck.get(0).getName();
            assertEquals("The Fool", output);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestDeckContents(){
        try {
            ArrayList<Card> thisDeck = Deck.getDeck();
            int deckLength = thisDeck.size();
            assertEquals(78, deckLength);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
