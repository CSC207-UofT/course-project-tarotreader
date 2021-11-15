package useCases;

import controllers.DataReader;
import entities.Card;

import java.io.IOException;
import java.util.ArrayList;

//CardInit implementation focusing on pulling data from the csv file using the data reader implementing the
// scanner.

public class CardInit {
    private static ArrayList<Card> cardList = new ArrayList<Card>();

    public static ArrayList<Card> getCardList() throws IOException {
        ArrayList<String[]> data = DataReader.readData("/Users/user/Downloads/cardconstants.csv");
        int length = data.size();
        int i = 0;
        while (i < length){
            String[] currline = data.get(i);
            Card newCard = null;
            if (currline.length == 4) {
                newCard = new Card(currline[0].strip(), currline[1].strip(), currline[2].strip(), currline[3].strip());
            } else if(currline.length == 5){
                newCard = new Card(currline[0].strip(), currline[1].strip(), currline[2].strip(), currline[3].strip(), currline[4].strip());
            }
            cardList.add(newCard);
            i ++;
        }
        return cardList;
    }
    public static void main (String[] args) throws IOException {
        cardList = getCardList();
        int counter = 0;
        for (int i = 0; i < cardList.size(); i++){
            System.out.println(cardList.get(i).getName());
            counter++;
        }
        System.out.println(counter);
    }
}

