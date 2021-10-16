package entities;

import java.io.IOException;
import java.util.ArrayList;

public class spreads {
    public static ArrayList<spread> spreadList;

    static {
        try {
            spreadList = spreadInit.getSpreads();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public spreads() throws IOException {
    }

    public static void main(String[] args) {
        System.out.println(spreadList.get(0));
    }
}





