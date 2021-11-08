package entities;
import useCases.SpreadInit;
import java.io.IOException;
import java.util.ArrayList;

public class Spreads {
    public static ArrayList<Spread> spreadList;

    static {
        try {
            spreadList = SpreadInit.getSpreads();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Spread> getSpreadList(){
        return spreadList;
    }

}




