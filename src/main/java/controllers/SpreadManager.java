package controllers;

import entities.Spread;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SpreadManager {

    private static List<Spread> spreads = new ArrayList<Spread>();

    public static Spread chooseSpread(ArrayList<Spread> spreadList, int index) {
        return spreadList.get(index);
    }

}
