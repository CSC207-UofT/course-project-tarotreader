
import controllers.ReadingGeneratorController;
import entities.*;
import org.junit.Test;
import useCases.ReadingGenerator;
import java.util.ArrayList;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReadingGeneratorControllerTest {

    @Test
    public void getInstance(){
        Object firstInstance = ReadingGeneratorController.getInstance();
        Object secondInstance = ReadingGeneratorController.getInstance();
        assertEquals(firstInstance, secondInstance);
    }

    @Test()
    public void testReadingGeneratorControllerIsPrivate() {
        final Constructor<?>[] constructors = ReadingGeneratorController.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
    }

    @Test
    public void TestShuffleDeck() {
        ArrayList<Card> origDeck = Deck.getDeck();
        ArrayList<Card> shuffledDeck = ReadingGeneratorController.shuffler(2);
        assertNotEquals(shuffledDeck, origDeck);
    }

    @Test
    public void TestCardPicker(){
        ArrayList<Card> origDeck = Deck.getDeck();
        ArrayList<Card> shuffledDeck = ReadingGeneratorController.shuffler(2);


        ArrayList<Integer> pickIndices = new ArrayList<>();
        pickIndices.add(0);
        pickIndices.add(1);
        ArrayList<Integer> pickIndices2 = new ArrayList<>();
        pickIndices.add(2);
        pickIndices.add(3);

        ArrayList<Card> testPickCards = ReadingGeneratorController.cardPicker(shuffledDeck, pickIndices);
        ArrayList<Card> secondTestPickCards = ReadingGeneratorController.cardPicker(shuffledDeck, pickIndices2);

        assertNotEquals(secondTestPickCards, testPickCards);
    }

    @Test
    public void TestCardPickerCorrectness()
    {
        Card newCard = new Card("testName", "2", "true", "generalMeaning",
                "generalMeaningRev", "loveMeaning", "loveMeaningRev",
                "careerMeaning", "careerMeaningRev");
        ArrayList<Card> shuffleDeck = new ArrayList<Card>();
        shuffleDeck.add(newCard);

        ArrayList<Integer> pickIndices = new ArrayList<>();
        pickIndices.add(0);

        ArrayList<Card> actualCardsReturned = ReadingGeneratorController.cardPicker(shuffleDeck, pickIndices);
        ArrayList<Card> expectedCardsReturned = new ArrayList<Card>();
        expectedCardsReturned.add(newCard);

        assertEquals(actualCardsReturned, expectedCardsReturned);
    }

    @Test
    public void TestGenerateReading(){
        //create input variables
        User user = new User("hazard" ,"Damien", 7, 5, 2);
        Spread spread = null;
        try {
            spread = new Spread("General Reading", "3");
        } catch (Spread.WrongSpreadType e) {
            System.out.println("Got interrupted...");
        }
        ArrayList<Card> origDeck = Deck.getDeck();
        ArrayList<Integer> pickIndices = new ArrayList<>();
        pickIndices.add(0);
        pickIndices.add(1);
        pickIndices.add(1);

        ArrayList<Card> pickedCards = ReadingGenerator.pickCard(origDeck, pickIndices);

        Reading currReading = ReadingGenerator.generateReading(user, spread, pickedCards);
        Reading newReading = ReadingGenerator.generateReading(user, spread, pickedCards);

        assertNotEquals(currReading, newReading);

        Reading secondReading = ReadingGenerator.generateReading(user, spread, origDeck);
        assertNotEquals(currReading, secondReading);

    }

}