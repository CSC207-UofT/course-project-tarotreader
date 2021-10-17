package controllers;
import useCases.shuffler;
import entities.card;
import java.util.ArrayList;

public class shuffleManager extends shuffler{
    public static ArrayList<card> shuffleNTimes(int n) throws Exception {
        ArrayList<card> result = new ArrayList<card>();
        if (n <= 0 || n > 10){
            throw new Exception("Please enter a valid input between 1 and 10");
        }
        for (int i = 1; i == n; i++){
            result = shuffleDeck();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(shuffleNTimes(4));
        System.out.println(shuffleNTimes(-3));
    }
}
