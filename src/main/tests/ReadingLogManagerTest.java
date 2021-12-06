import useCases.ReadingLogManager;
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
        ReadingLog log2 = new ReadingLogManager().viewLog(user);
        assert(Objects.equals(log1, log2));
    }

    @Test
    public void viewLReadingTest() throws Spread.WrongSpreadType {
        User user = new User("test", "test123", 1999, 1, 1);
        ArrayList<Card> deck = ReadingGenerator.shuffleDeck(3);
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.add(5);
        index.add(20);
        index.add(43);
        Spread spread = new Spread("General", "3");
        Reading reading = ReadingGenerator.generateReading(user, spread, deck, index);
        reading.readingName = "test";
        String reading1 = reading.toString();
        String reading2 = new ReadingLogManager().viewReading(user, "test");
        assert(Objects.equals(reading1, reading2));
    }
}
