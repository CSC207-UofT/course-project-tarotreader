package useCases;

import java.util.Random;
import entities.card;
import entities.deck;
import java.util.ArrayList;
import java.util.Collections;

public class shuffler {
    public static ArrayList<card> shuffleDeck(){
        ArrayList<card> deckClone = (ArrayList<card>)deck.getDeck().clone();

        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1;
        for (int i = 0; i < randomNumber; i++){
            Collections.shuffle(deckClone);
        }
        return deckClone;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(shuffleDeck());
    }
}