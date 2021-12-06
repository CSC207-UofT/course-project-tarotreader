import entities.*;
import org.junit.Test;
import useCases.ReadingGenerator;

import java.util.ArrayList;
import java.util.Collections;

public class ReadingLogTest {

    public ReadingLogTest(){
    }

    @Test
    public void TestGetReadings() {
        try {
            User u = new User("eliferzincan", "20012001", 2001, 4, 30);
            ReadingLog readingLog = new ReadingLog(u);
            assert readingLog.getReadings().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestAddToLog() {
        try {
            User u = new User("eliferzincan", "20012001", 2001, 4, 30);
            ReadingLog readingLog = new ReadingLog(u);
            Spread s = new Spread("ExampleSpread", "50");
            ArrayList<Card> shuffledDeck = ReadingGenerator.shuffleDeck(3);
            ArrayList<Card> a = new ArrayList<>();
            ArrayList<Integer> indecies = new ArrayList<>();
            indecies.add(1);
            indecies.add(2);
            indecies.add(3);
            a.addAll(ReadingGenerator.pickCard(shuffledDeck, indecies));
            Reading r = new Reading(a, u, s);
            r.addCardMeanings(a, s);
            readingLog.addToLog(r);
            assert !readingLog.getReadings().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}