package controllers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {

    public static ArrayList<String[]> readData(String fileName) throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        BufferedReader dataReader = null;
        try {
            dataReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line ;
        while ((line = dataReader.readLine()) != null) {
            String[] elem = line.split(",");
            data.add(elem);
        }
        return data;
    }
}