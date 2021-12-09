import controllers.LoginController;
import controllers.UserGeneratorController;
import entities.*;
import org.junit.Test;
import static org.junit.Assert.*;
import useCases.LogIn;
import useCases.ReadingGenerator;
import useCases.SpreadInit;
import useCases.UserGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingGeneratorTests {
    @Test
    public void ShufflerTest() {
        ArrayList<Card> origDeck = Deck.getDeck();
        ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(3);
        assertNotEquals(shuffledDeck, origDeck);
    }

    @Test
    public void PickCardsTest() throws Spread.WrongSpreadType, IOException {
        ArrayList<Integer> pickedIndex = new ArrayList<>();
        ArrayList<Spread> spreadList = SpreadInit.getSpreads();
        ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(3);
        pickedIndex.add(1);
        pickedIndex.add(3);
        pickedIndex.add(5);
        ArrayList<Card> pickedCards = ReadingGenerator.pickCard(shuffledDeck, pickedIndex);
        assertEquals(3, pickedCards.size());
        assert(!pickedCards.contains(null));
    }
    @Test
    public void GenerateReadingTest() throws Exception {
        File serFile = new File("testGenReading.ser");
        boolean exists = serFile.exists();
        if(exists){
            User thisUser = (User) LoginController.getInstance().login("testGenReading", "TestTest123");
            ArrayList<Integer> pickedIndex = new ArrayList<>();
            ArrayList<Spread> spreadList = SpreadInit.getSpreads();
            ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(3);
            assertEquals(4, spreadList.size());
            pickedIndex.add(1);
            pickedIndex.add(3);
            pickedIndex.add(5);
            ArrayList<Card> pickedCards = ReadingGenerator.pickCard(shuffledDeck, pickedIndex);
            Reading thisReading = ReadingGenerator.generateReading(thisUser, spreadList.get(0), pickedCards);
            assertNotEquals(null, thisReading);
            assert(thisReading.toString().contains("General Reading"));
        }else{
            UserGeneratorController.getInstance().generateUser("testGenReading", "TestTest123", 1999, 1, 1);
            User thisUser = (User) LoginController.getInstance().login("testGenReading", "TestTest123");
            ArrayList<Integer> pickedIndex = new ArrayList<>();
            ArrayList<Spread> spreadList = SpreadInit.getSpreads();
            ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(3);
            assertEquals(4, spreadList.size());
            pickedIndex.add(1);
            pickedIndex.add(3);
            pickedIndex.add(5);
            ArrayList<Card> pickedCards = ReadingGenerator.pickCard(shuffledDeck, pickedIndex);
            Reading thisReading = ReadingGenerator.generateReading(thisUser, spreadList.get(0), pickedCards);
            assertNotEquals(null, thisReading);
            assert(thisReading.toString().contains("General Reading"));
        }

    }
}