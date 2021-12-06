import controllers.DataReader;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class DataReaderTest {

    @Test
    public void dataReader() throws IOException {
        ArrayList<String[]> data = DataReader.readData("resources/spreadConstants");
        String[] expected = {"General Reading", " 3"};
        assertEquals(expected, data.get(0));
    }
    @Test
    public void dataReaderFileNotFound() throws IOException {
        FileNotFoundException thrown = assertThrows(FileNotFoundException.class, () -> DataReader.readData("x"),
                "File not found.");
        assertTrue(thrown.getMessage().contains("File not found."));
    }
}
