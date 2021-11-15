package useCases;

import controllers.DataReader;
import entities.Spread;
import java.io.IOException;
import java.util.ArrayList;

public class SpreadInit {
    /***
     * A method for initializing spread objects from a constants file using the DataReader controller
     */
    // private static ArrayList<Spread> spreadList = new ArrayList<>();

    public static ArrayList<Spread> getSpreads() throws IOException {
        ArrayList<String[]> data = DataReader.readData("resources/spreadConstants");// Reads data from constants
                                                                                            // file using DataReader
                                                                                            // readData() method
        ArrayList<Spread> spreadList = new ArrayList<>();
        int length = data.size();
        int i = 0;
        while (i < length){     // iterates through data to initialize each card object
            String[] currLine = data.get(i);
            Spread newSpread;
            newSpread = new Spread(currLine[0].strip(), currLine[1].strip());   // call to spread constructor
            spreadList.add(newSpread);      // adds newly created spread to spreadList
            i ++;
        }
        return spreadList;
    }
}
