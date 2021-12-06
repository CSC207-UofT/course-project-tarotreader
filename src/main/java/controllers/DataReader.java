package controllers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {
    /***
     * A class that holds a method for reading a file. Returns data in string format.
     * @param fileName name of file to read from
     * @return ArrayList<String[]>
     * @throws IOException if file not found
     */
    public static ArrayList<String[]> readData(String fileName) throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        BufferedReader dataReader = null;                   // Uses BufferedReader to do file reading
        try {
            dataReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {                  // Throws exception if file does not exist
            e.printStackTrace();
        }
        String line ;
        while (true) {
            assert dataReader != null;
            if ((line = dataReader.readLine()) == null) break;    // Reads until end of file
            String[] elem = line.split(";");          // Uses comma as delimiter
            data.add(elem);
        }
        return data;
    }
}