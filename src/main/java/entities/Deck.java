package entities;
import useCases.CardInit;
import java.io.IOException;
import java.util.ArrayList;

//public class Deck {
    //public static ArrayList<Card> cardList;

    //static {
        //try {
           // cardList = CardInit.getCardList();
        //} catch (IOException e) {
         //   e.printStackTrace();
       // }
   // }

   // public static ArrayList<Card> getDeck(){
    //    return cardList;
  //  }

//    public static void main(String[] args) {
//        int i = 0;
//        ArrayList<Integer> temp = new ArrayList<>();
//        for (Card c : cardList) {
//            if (c == null) {
//                temp.add(i);
//            }
//            i++;
//        }
//        System.out.println(temp);
//        System.out.println(cardList);
//    }


public class Deck {
    //this holds an arraylist of card objects
    private ArrayList<Card> cardList;

    public Deck() {
        this.cardList = new ArrayList<Card>();

    }

    public Deck(ArrayList<Card> cardList) {
        this.cardList = new ArrayList<Card>();
        this.cardList.addAll(cardList);
    }
}

