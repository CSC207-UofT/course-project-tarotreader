import entities.*;
import org.junit.Test;
import java.util.ArrayList;

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
            ArrayList<Card> a = new ArrayList<>();
            Reading r = new Reading(u, s);
            r.addCardMeanings(a);
            readingLog.addToLog(r);
            assert !readingLog.getReadings().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}