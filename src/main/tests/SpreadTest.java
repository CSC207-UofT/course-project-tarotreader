import entities.Spread;
import org.junit.Test;
import useCases.SpreadInit;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;

public class SpreadTest {

    public SpreadTest() throws IOException {
    }

    @Test
    public void TestSpreadContents() {
        try{
            ArrayList<Spread> spreadList = Spread.getSpreadList();
            assertEquals("General Reading", spreadList.get(0).getSpreadName());
            assertEquals(3, spreadList.get(0).getNumCards());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

