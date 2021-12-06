import controllers.LoginController;
import controllers.UserGeneratorController;
import entities.*;
import org.junit.Test;
import static org.junit.Assert.*;
import useCases.LogIn;
import useCases.ReadingGenerator;
import useCases.SpreadInit;
import useCases.UserGenerator;

import java.io.IOException;
import java.util.ArrayList;

public class ReadingGeneratorTests {
    @Test
    public void shufflerTest() {
        ArrayList<Card> origDeck = Deck.getDeck();
        ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(3);
        assertNotEquals(shuffledDeck, origDeck);
    }

    @Test
    public void GenerateReadingTest() throws Exception {
        UserGeneratorController.getInstance().generateUser("test", "test123", 1999, 1, 1);
        User thisUser = (User) LoginController.getInstance().login("test", "test123");
        ArrayList<Integer> pickedIndex = new ArrayList<>();
        ArrayList<Spread> spreadList = SpreadInit.getSpreads();
        ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(3);
        assertEquals(4, spreadList.size());
        pickedIndex.add(1);
        pickedIndex.add(3);
        pickedIndex.add(5);
        Reading thisReading = ReadingGenerator.generateReading(thisUser, spreadList.get(0), shuffledDeck, pickedIndex);
        assertNotEquals(null, thisReading);
        assert(thisReading.toString().contains("General Reading"));
    }
}
