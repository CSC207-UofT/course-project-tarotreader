import entities.Card;
import entities.Deck;
import org.junit.Test;
import useCases.Shuffler;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class ShufflerTest {
    @Test
    public void testShuffler() {
        try {
            ArrayList<Card> origDeck = Deck.getDeck();
            ArrayList<Card> shuffledDeck1 = Shuffler.shuffleDeck(3);
            ArrayList<Card> shuffledDeck2 = Shuffler.shuffleDeck(3);
            assertNotEquals(shuffledDeck1, shuffledDeck2);
            assertNotEquals(origDeck, shuffledDeck2);
            assertNotEquals(origDeck, shuffledDeck1);
            assertEquals("The Fool", origDeck.get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
