package controllers;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {

    public static ArrayList<String[]> readData(String fileName) throws IOException{
        ArrayList<String[]> data = new ArrayList<>();
        Scanner dataReader = null;
        try{
            dataReader = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dataReader.useDelimiter(",");
        while (dataReader.hasNext()){
            System.out.println(dataReader.next());
        }
        return data;
    }
}
