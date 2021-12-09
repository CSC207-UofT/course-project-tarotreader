import entities.Spread;
import org.junit.Test;
import useCases.SpreadInit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.ArrayList;

public class SpreadTest {

    @Test
    public void TestSpreadInit() throws Spread.WrongSpreadType, IOException {
        ArrayList<Spread> spreadList = SpreadInit.getSpreads();
        assertEquals(4, spreadList.size());
        assert(!spreadList.contains(null));
    }
    @Test
    public void TestSpreadConstructor() throws Spread.WrongSpreadType {
        Spread testSpread = new Spread("General Reading", "3");
        assert(testSpread instanceof Spread);
        assertEquals(3, testSpread.getNumCards());
        assertEquals("General", testSpread.getRequiredMeaningType());
        assertEquals("General Reading", testSpread.getSpreadName());
    }
    @Test
    public void getSpreadContents() throws Spread.WrongSpreadType, IOException {
        ArrayList<Spread> spreads = Spread.getSpreadList();
        assertEquals(4, spreads.size());
        assertEquals("General Reading", spreads.get(0).getSpreadName());
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
    @Test
    public void TestGetSpreadName(){
        try{
            ArrayList<Spread> spreadList = Spread.getSpreadList();
            String expectedName = "General Reading";
            String actualName = spreadList.get(0).getSpreadName();
            assertEquals(expectedName, actualName);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestGetRequiredMeaningType() throws Spread.WrongSpreadType {
        Spread genSpread = new Spread("General Reading", "3");
        String expectedMeaningType = "General";
        String actualMeaningType = genSpread.getRequiredMeaningType();
        assertEquals(expectedMeaningType, actualMeaningType);
    }

    @Test
    public void TestGetRequiredMeaningTypeWrongSpreadName() throws Spread.WrongSpreadType {
        Spread.WrongSpreadType thrown = assertThrows(Spread.WrongSpreadType.class, () -> new Spread("wrongSpread", "3").getRequiredMeaningType(), "Spread type does not exist. Please try again");
        assertTrue(thrown.getMessage().contains("Spread type does not exist. Please try again"));
    }

    @Test
    public void TestGetNumCards() throws Spread.WrongSpreadType {
        Spread genSpread = new Spread("General Reading", "3");
        Integer expected = 3;
        Integer actual = genSpread.getNumCards();
        assertEquals(expected, actual);

    }
}