package controllers;



public class spreadManager {

    /**
     * Takes a number of cards picked and returns which spread it represents.
     * @param numCards The number of cards picked
     * @return The represented spread name as a String
     */
    public static String chooseSpread(int numCards) {
        if (numCards == 3) {
            return "General";
        }
        return "No spread exists for this number of cards.";
    }
}
