package controllers;
import useCases.CardLookup;
public class CardLookupController {
        public CardLookupController(){
            /*
         Creates a CardLookupController
         */
        }

    public String getCardList(){
        CardLookup cardLookup = new CardLookup();
        return cardLookup.getCardsList();
    }
    public String searchCard(String searchQ){
        CardLookup cardLookup = new CardLookup();
        String s = "";
        s = cardLookup.searchCard(searchQ);
        if (s.isEmpty()){
            System.out.println("No cards have been selected");
        }
        return s;
    }
}

