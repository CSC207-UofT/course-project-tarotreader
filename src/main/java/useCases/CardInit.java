package useCases;
import entities.Card;
import controllers.DataReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardInit {
    /***
     * A method for initializing card objects from a constants file using the DataReader controller
     */
    private static ArrayList<Card> cardList = new ArrayList<>();

    public static ArrayList<Card> getCardList() throws IOException {
        ArrayList<String[]> data = DataReader.readData("resources/cardConstants"); // Reads data from constants
                                                                                           // file using DataReader
                                                                                           // readData() method
        int length = data.size();
        int i = 0;
        while (i < length){     // iterates through data to initialize each card object
            String[] currLine = data.get(i);
            Card newCard = null;
            if (currLine.length == 4) {     // If currLine has 4 elements, use Major card constructor
                newCard = new Card(currLine[0].strip(), currLine[1].strip(), currLine[2].strip(), currLine[3].strip());
            } else if (currLine.length == 5) {      // Else currLine will have 5 elements, use Minor card constructor
                newCard = new Card(currLine[0].strip(), currLine[1].strip(), currLine[2].strip(), currLine[3].strip(),
                        currLine[4].strip());
            }
            cardList.add(newCard);      // Add each newly constructed card to cardList
            i ++;
        }
        return cardList;
    }
}
