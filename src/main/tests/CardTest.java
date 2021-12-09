import entities.Card;
import entities.Deck;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CardTest {

    @Test
    public void TestMajorCardConstructor(){
        Card testFool = new Card("The Fool", "0", "true", "test meaning",
                "test meaning", "test meaning", "test meaning",
                "test meaning", "test meaning");
        Boolean isCard = testFool instanceof Card;
        assertEquals(true, isCard);
        assertEquals("The Fool", testFool.getName());
    }

    @Test
    public void TestMinorCardConstructor(){
        Card testAceOfWands = new Card("Ace of Wands", "1", "false", "Wands", "test meaning",
                "test meaning", "test meaning", "test meaning",
                "test meaning", "test meaning");
        Boolean isCard = testAceOfWands instanceof Card;
        assertEquals(true, isCard);
        assertEquals("Ace of Wands", testAceOfWands.getName());
        assert(testAceOfWands.toString().contains("Wands"));
    }

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
        String expected = "Signals the beginning of a new journey, one where you will be filled with optimism and " +
                "freedom from the usual constraints in life. Approach each day as an adventure, in an almost " +
                "childish way. Anything can happen in life and there are many opportunities that are lying out there," +
                " in the world, waiting to be explored and developed. Lead a simple life, have no worries, and do" +
                " not be troubled by the fact that he cannot tell what he will encounter ahead.";
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
                "General Meaning: Signals the beginning of a new journey, one where you will be filled with " +
                "optimism and freedom from the usual constraints in life. Approach each day as an adventure, in " +
                "an almost childish way. Anything can happen in life and there are many opportunities that are lying" +
                " out there, in the world, waiting to be explored and developed. Lead a simple life, have no worries," +
                " and do not be troubled by the fact that he cannot tell what he will encounter ahead.\n" +
                "General Meaning Reversed: A reversed Fool card can show that you are living in the moment and not" +
                " planning for the future. The reversed Fool meaning serves as caution that you should be more aware" +
                " so as not to be taken advantage of. Like the dog in the Rider Waite version, this card is here to" +
                " alert you on anything that may sound too good to be true.\n" + "Love Meaning: Get ready to embark " +
                "on a new adventure. The Fool tarot meaning in love signals that you'll need to experience new things" +
                " in order to find the romance that you desire. Be willing to take risks, be bold and expand your " +
                "vision of the world and you may end up finding love in the most unlikely places. Surprises are in" +
                " store for you.\n" + "Love Meaning Reversed: When the Fool is reversed in a love tarot reading, " +
                "this card can signal that your bright-eyed, trusting nature may need to be tempered with a dose of" +
                " caution. Especially when with new lovers, make sure that everything is what it seems to be. You may" +
                " now be looking at love with rose-tinted glasses, and unable to see a clear picture of the " +
                "relationship.\n" + "Career Meaning: New beginnings are on their way, when the Fool appears in your " +
                "career tarot reading. If you’ve been looking to start a new career path, change jobs, get a " +
                "promotion, or even start your own venture, the Fool can be a welcome card to begin your new journey." +
                " Even if no new drastic changes are coming your way or planned, this card can feel like a " +
                "fresh breath of air into old projects. You can be filled with new energy, and new innovative " +
                "ideas can be put into action now. What is important now is to be very aware of the opportunities" +
                " that are there, and have the courage to take them when they appear.\n" + "Career Meaning Reversed:" +
                " You may have all the energy in the world, and eagerness to do use that energy, however," +
                " you may not quite have the insight to do so without any consequences. Try and be more aware" +
                " about how your actions affect your colleagues right now, and think before you take action." +
                " Other times, the reversed Fool can signal that your current job feels stale and boring, and you" +
                " may be feeling like it’s time for a change. Sometimes, this indicates that you may feel blocked " +
                "from actually doing so, or that you need to consider these plans very carefully before making that" +
                " choice. It may be that there are more dangers than you see right now.\n";
        String actual = deck.get(0).toString();
        assertEquals(expected, actual);
    }
}