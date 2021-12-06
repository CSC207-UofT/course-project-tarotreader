import entities.Card;
import entities.Deck;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CardTest {
    @Test
    public void TestGetName(){
        ArrayList<Card> deck = (ArrayList<Card>) Deck.getDeck().clone();
        String expected = "The Fool";
        String actual = deck.get(0).getName();
        assertEquals(expected, actual);
    }
    @Test
    public void TestGetMeaning(){
        ArrayList<Card> newDeck = (ArrayList<Card>) Deck.getDeck().clone();
        String expected = "New Beginnings. This card speaks about starting from a clean slate and represents purity " +
                "and innocence. Signals a new journey but have caution to the potential dangers that you could " +
                "encounter.";
        String actual = newDeck.get(0).getMeaning("General");
        assertEquals(expected, actual);
    }
    @Test
    public void TestIsReversed(){
        ArrayList<Card> origDeck = (ArrayList<Card>) Deck.getDeck().clone();
        Boolean expected = false;
        Boolean actual = origDeck.get(0).isReversed();
        assertEquals(expected, actual);
    }

    @Test
    public void TestSetReversed(){
        ArrayList<Card> deck = (ArrayList<Card>) Deck.getDeck().clone();
        deck.get(0).setReversed(true);
        Boolean expected = true;
        Boolean actual = deck.get(0).isReversed();
        assertEquals(expected, actual);
        deck.get(0).setReversed(false);
        Boolean actual2 = deck.get(0).isReversed();
        assertNotEquals(expected, actual2);
    }

    @Test
    public void TestGetNumber(){
        ArrayList<Card> deck = (ArrayList<Card>) Deck.getDeck().clone();
        Integer expected = 0;
        Integer actual = deck.get(0).getNumber();
    }



    @Test
    public void TestToString(){
        ArrayList<Card> deck = (ArrayList<Card>) Deck.getDeck().clone();
        String expected = "The Fool (Major)\n" +
                "General Meaning: New Beginnings. This card speaks about starting from a clean slate and represents " +
                "purity and innocence. Signals a new journey but have caution to the potential dangers that you could " +
                "encounter.\nLove Meaning: na\nCareer Meaning: na\n";
        String actual = deck.get(0).toString();
        assertEquals(expected, actual);
    }
}
