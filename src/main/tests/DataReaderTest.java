import controllers.DataReader;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataReaderTest {
    @Test
    public void dataReader() throws IOException {
        ArrayList<String[]> data = DataReader.readData("resources/spreadConstants");
        String[] expected = {"General Reading", " 3"};
        assertEquals(expected, data.get(0));
    }
}
