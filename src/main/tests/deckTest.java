import entities.deck;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import entities.card;
import entities.cardInit;
import entities.deck;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

public class deckTest {
    ArrayList<card> thisDeck = cardInit.getCardList();

    public deckTest() throws IOException {
    }

    @Test
    public void TestInitialCardListContents(){
        try {
            String output = thisDeck.get(0).getName();
            assertEquals("The Fool", output);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestDeckContents(){
        try {
            ArrayList<card> thisDeck = deck.getDeck();
            int deckLength = thisDeck.size();
            assertEquals(78, deckLength);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
