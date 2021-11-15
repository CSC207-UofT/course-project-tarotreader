package useCases;
import entities.Card;
import controllers.DataReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardInit {
    private static ArrayList<Card> cardList = new ArrayList<>();

    public static ArrayList<Card> getCardList() throws IOException {
        ArrayList<String[]> data = DataReader.readData("resources/cardConstants");
        int length = data.size();
        int i = 0;
        while (i < length){
            String[] currLine = data.get(i);
            Card newCard = null;
            if (currLine.length == 4) {
                newCard = new Card(currLine[0].strip(), currLine[1].strip(), currLine[2].strip(), currLine[3].strip());
            } else if (currLine.length == 5) {
                newCard = new Card(currLine[0].strip(), currLine[1].strip(), currLine[2].strip(), currLine[3].strip(), currLine[4].strip());
            }
            cardList.add(newCard);
            i ++;
        }
        return cardList;
    }
}
