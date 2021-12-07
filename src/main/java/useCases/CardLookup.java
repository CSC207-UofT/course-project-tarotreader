package useCases;
import entities.Card;
import entities.Deck;
import java.util.ArrayList;

public class CardLookup {

    /**
     * A method for accessing the list of card names
     * @return the list of card names as a string, seperated by lines
     */
    public String getCardsList() {
        ArrayList<Card> deck = Deck.getDeck(); // Get deck
        StringBuilder list = new StringBuilder();
        // Append all card names to the StringBuilder object with a newline character at the end
        for (Card card: deck) {
            list.append(card.getName()).append("\n");
        }
        return list.toString();
    }

    /**
     * A method for searching specific cards in the deck
     * @param searchQuery the string to search for
     * @return a list of cards whose names contain the query string
     */
    public String searchCard(String searchQuery) {
        ArrayList<Card> deck = Deck.getDeck();
        ArrayList<Card> queriedCards = new ArrayList<>();
        for (Card card: deck) {
            if (card.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                queriedCards.add(card);
            }
        }
        // TODO: Add check to CLI for return value null of searchCard
        String result = "";
        for(Card c: queriedCards){
            result = result.concat(c.toString());
        }
        return result;
    }
}
