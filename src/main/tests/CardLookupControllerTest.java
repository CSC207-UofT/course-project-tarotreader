import controllers.CardLookupController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardLookupControllerTest{
    @Test
    public void testGetCardList(){
        CardLookupController cardLookupController = new CardLookupController();
        String fistCardList = cardLookupController.getCardList();
        String secondCardList = cardLookupController.getCardList();
        assertEquals(fistCardList, secondCardList);
    }

    @Test
    public void testSearchCards(){
        CardLookupController cardLookupController = new CardLookupController();

        String myCard = cardLookupController.searchCard("myFakeCard");
        String mySecondCard = cardLookupController.searchCard("myFakeCard");
        assertEquals(myCard, mySecondCard);

    }
}