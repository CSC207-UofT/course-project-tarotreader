package controllers;

import entities.Spread;

import java.util.ArrayList;
import java.util.List;

public class SpreadManager {

    private static List<Spread> spreads = new ArrayList<Spread>();

    public static Spread chooseSpread(int index) {
        return spreads.get(index);
    }

}
