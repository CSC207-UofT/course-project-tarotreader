package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class cardInit {
    private static ArrayList<card> cardList = new ArrayList<>();
    private static BufferedReader TarotReader;

    static {
        try {
            TarotReader = new BufferedReader(new FileReader("resources/cardConstants"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public cardInit() throws FileNotFoundException {
    }


    public static ArrayList<card> getCardList() throws IOException {
        String line;
        while ((line = TarotReader.readLine()) != null){
            String[] elem = line.split(",");
            card newCard = null;
            if(elem.length == 4){
                newCard = new card(elem[0].strip(), elem[1].strip(), elem[2].strip(), elem[3].strip());
            }else if(elem.length == 5){
                newCard = new card(elem[0].strip(), elem[1].strip(), elem[2].strip(), elem[3].strip(), elem[4].strip());
            }
            cardList.add(newCard);

        }
        return cardList;
    }
}