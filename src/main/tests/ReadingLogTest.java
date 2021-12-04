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
            ReadingLog readingLog = new ReadingLog();
            assert readingLog.getReadings().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestAddToLog() {
        try {
            User u = new User("eliferzincan", "20012001", 2001, 4, 30);
            Spread s = new Spread("ExampleSpread", "50");
            ArrayList<Card> a = new ArrayList<>();
            Reading r = new Reading(a, u, s);
            u.getReadingLog().addToLog(r);
            assert !u.getReadingLog().getReadings().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}