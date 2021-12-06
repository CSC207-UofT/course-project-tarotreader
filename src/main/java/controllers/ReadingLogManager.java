package controllers;

import entities.User;
import entities.Reading;
import entities.ReadingLog;
import useCases.ReadingLogActions;

import java.util.Scanner;

public class ReadingLogManager {

    private User loggedInUser;

    //Creates a ReadingLogManager object with the logged in User.
    public ReadingLogManager(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //Adds the reading generated to the user's reading log.
    public void logReading(Reading reading, String readingName) {
        //*

        // @param reading: The Reading object generated and to be added to the user's reading log.
        //
        ReadingLogActions actions = new ReadingLogActions();
        actions.nameReading(loggedInUser, reading.getReadingName(), readingName);
        ReadingLog readingLog = loggedInUser.getReadingLog();
        readingLog.addToLog(reading);
    }
}
