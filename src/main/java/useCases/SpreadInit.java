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
            newSpread = new Spread(currLine[0], currLine[1]);
            spreadList.add(newSpread);
            i ++;
        }
        return spreadList;
    }
   /* public static void main(String[] args) throws IOException {
        spreadList = getSpreads();
        int counter = 0;
        for (Spread spread : spreadList) {
            System.out.println(spread.getSpreadName());
            System.out.println(spread.getNumCards());
            counter++;
        }
        System.out.println(counter);
    }*/
}
