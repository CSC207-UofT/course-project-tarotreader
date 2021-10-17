package controllers;

import entities.spread;

import java.util.ArrayList;
import java.util.List;

public class spreadManager {

    private static List<spread> spreads = new ArrayList<spread>();

    public static spread chooseSpread(int index) {
        return spreads.get(index);
    }

}
