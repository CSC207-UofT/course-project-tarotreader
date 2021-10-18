package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SpreadInit {
    private static ArrayList<Spread> spreadList = new ArrayList<>();
    private static BufferedReader SpreadReader;

    static {
        try {
            SpreadReader = new BufferedReader(new FileReader("resources/spreadConstants"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public SpreadInit() throws FileNotFoundException {
    }

    public static ArrayList<Spread> getSpreads() throws IOException {
        String line;
        while ((line = SpreadReader.readLine()) != null){
            String[] elem = line.split(",");
            Spread newSpread;
            if(elem.length == 2){
                newSpread = new Spread(elem[0], elem[1]);
            }else{
                newSpread = new Spread(elem[0], elem[1], elem[2]);
            }
            spreadList.add(newSpread);

        }
        return spreadList;
    }

}
