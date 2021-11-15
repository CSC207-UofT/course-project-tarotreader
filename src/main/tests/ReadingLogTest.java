import entities.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ReadingLogTest {

    public ReadingLogTest() throws IOException {
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
            ArrayList<Card> a = new ArrayList<Card>();
            Reading r = new Reading(a, u, s);
            readingLog.addToLog(r);
            assert !readingLog.getReadings().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestToString() {
        try {
            User u = new User("eliferzincan", "20012001", 2001, 4, 30);
            ReadingLog readingLog = new ReadingLog(u);
            Spread s = new Spread("ExampleSpread", "50");
            ArrayList<Card> a = new ArrayList<Card>();
            Reading r = new Reading(a, u, s);
            readingLog.addToLog(r);
            assert readingLog.toString().matches("Hey eliferzincan! You have chosen the ExampleSpread. Here is your reading for today");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}