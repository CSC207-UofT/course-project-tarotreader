package controllers;

import entities.Card;
import entities.Reading;
import entities.Spread;
import entities.User;
import useCases.ReadingGenerator;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * TODO: Add add the java doc description to this class
 */
public class ReadingGeneratorController {
    private static final ReadingGeneratorController controllerInstance = new ReadingGeneratorController();
    private ReadingGeneratorController(){
        /*
        Private constructor so that client-side cannot instantiate this singleton
         */
    }
    public static ReadingGeneratorController getInstance() {return controllerInstance;}

    public static ArrayList<Card> shuffler(int shuffleCount){
        return ReadingGenerator.shuffleDeck(shuffleCount);
    }
    public static ArrayList<Card> cardPicker(ArrayList<Card> shuffledDeck, ArrayList<Integer> chosenIndices){
        return ReadingGenerator.pickCard(shuffledDeck, chosenIndices);
    }
    public static Reading readingGenerator(User user, Spread spread, ArrayList<Card> pickedCards){
        return ReadingGenerator.generateReading(user, spread, pickedCards);
    }
}
