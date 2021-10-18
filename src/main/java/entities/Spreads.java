package entities;

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

    public Spreads() throws IOException {
    }

    public static void main(String[] args) {
        System.out.println(spreadList.get(0));
    }
}




