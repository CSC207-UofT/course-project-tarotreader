package useCases;

import controllers.DataReader;
import entities.Spread;
import java.io.IOException;
import java.util.ArrayList;

public class SpreadInit {
    private static ArrayList<Spread> spreadList = new ArrayList<>();

    public static ArrayList<Spread> getSpreads() throws IOException {
        ArrayList<String[]> data = DataReader.readData("resources/spreadConstants");
        int length = data.size();
        int i = 0;
        while (i < length){
            String[] currLine = data.get(i);
            Spread newSpread;
            newSpread = new Spread(currLine[0].strip(), currLine[1].strip());
            spreadList.add(newSpread);
            i ++;
        }
        return spreadList;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Spread> lst = SpreadInit.getSpreads();
        for(int i = 0; i<lst.size(); i++){
            System.out.println(lst.get(i));
        }
    }
}
