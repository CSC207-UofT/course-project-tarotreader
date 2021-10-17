import entities.card;
import entities.deck;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import useCases.shuffler;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

public class shufflerTest {
    @Test
    public void testShuffler() {
        try {
            ArrayList<card> origDeck = deck.getDeck();
            ArrayList<card> shuffledDeck1 = shuffler.shuffleDeck(3);
            ArrayList<card> shuffledDeck2 = shuffler.shuffleDeck(3);
            assertNotEquals(shuffledDeck1, shuffledDeck2);
            assertNotEquals(origDeck, shuffledDeck2);
            assertNotEquals(origDeck, shuffledDeck1);
            assertEquals("The Fool", origDeck.get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
