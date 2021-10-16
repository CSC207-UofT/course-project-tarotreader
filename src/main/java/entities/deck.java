package entities;

import java.io.IOException;
import java.util.ArrayList;

public class deck{
    public static ArrayList<card> cardList;

    static {
        try {
            cardList = cardInit.getCardList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(cardList.get(77));
    }
}