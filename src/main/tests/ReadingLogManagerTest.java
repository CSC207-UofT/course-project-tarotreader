import useCases.ReadingLogActions;
import entities.*;
import org.junit.Test;
import useCases.ReadingGenerator;

import java.util.ArrayList;
import java.util.Objects;

public class ReadingLogManagerTest {
    @Test
    public void viewLogTest(){
        User user = new User("test", "test123", 1999, 1, 1);
        ReadingLog log1 = user.getReadingLog();
        ReadingLog log2 = new ReadingLogActions().viewLog(user);
        assert(Objects.equals(log1, log2));
    }

    @Test
    public void viewLReadingTest() throws Spread.WrongSpreadType {
        User user = new User("test", "Test1234", 1999, 1, 1);
        ArrayList<Card> deck = ReadingGenerator.shuffleDeck(3);
        ArrayList<Integer> index = new ArrayList<>();
        index.add(5);
        index.add(20);
        index.add(43);
        Spread spread = new Spread("General Reading", "3");
        ArrayList<Card> pickedCards = new ArrayList<>();
        pickedCards.add(deck.get(index.get(0)));
        pickedCards.add(deck.get(index.get(1)));
        pickedCards.add(deck.get(index.get(2)));

        Reading reading = ReadingGenerator.generateReading(user, spread, pickedCards);
        reading.setReadingName("test");
        ReadingLogActions actions = new ReadingLogActions();
        actions.logReading(user, reading);

        String reading1 = reading.toString();
        String reading2 = new ReadingLogActions().viewReading(user, "test");
        assert(Objects.equals(reading1, reading2));
    }
}
