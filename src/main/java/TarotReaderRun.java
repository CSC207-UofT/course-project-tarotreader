import controllers.CardPicker;
import controllers.ReadingLogManager;
import controllers.ShuffleManager;
import controllers.SpreadManager;
import entities.*;
import useCases.TarotReader;
import java.util.ArrayList;

public class TarotReaderRun {
    private static ReadingLog ArrayList;

    public static void main(String[] args) throws Exception {
        int numShuffle = 3;
        ArrayList<Card> newDeck = Deck.getDeck();
        ArrayList<Spread> spreads = Spreads.getSpreadList();
        User newUser = new User("tarotReaderUser", 1999, 1, 13);
        System.out.println("Hello new user " + newUser.getUsername() + ", you have successfully created your account!");
        Spread spread = SpreadManager.chooseSpread(spreads, 0);
        java.util.ArrayList<Card> shuffledDeck = ShuffleManager.shuffleNTimes(3);
        for(int i = 0; i < numShuffle; i++){
            System.out.println("Shuffling...");
        }
        ArrayList<Card> chosenCards = CardPicker.getPickedCards(shuffledDeck);
        TarotReader reading = new TarotReader(chosenCards);
        System.out.println("You have chosen a " + spread.getSpreadName() + ". \n" + reading.toString());
        ReadingLogManager.addLog(newUser);
        ReadingLogManager.logReading(newUser, reading);
        ReadingLog readingLog = newUser.getReadingLog();
        System.out.println("Here is your reading log: \n" + readingLog.toString());
    }
}
