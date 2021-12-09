package controllers;

import entities.User;
import entities.Reading;
import entities.ReadingLog;
import useCases.ReadingLogActions;

import java.util.Scanner;

public class ReadingLogManager {

    private User loggedInUser;
    private ReadingLogActions actions;

    public ReadingLogManager() {
        actions = new ReadingLogActions();
    }

    //Creates a ReadingLogManager object with the logged in User.
    public ReadingLogManager(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //Adds the reading generated to the user's reading log.
    public void logReading(Reading reading, String readingName) {
        //*

        // @param reading: The Reading object generated and to be added to the user's reading log.
        //
        actions = new ReadingLogActions();
        ReadingLog readingLog = loggedInUser.getReadingLog();
        readingLog.addToLog(reading);
        actions.logReading(loggedInUser, reading);
        actions.nameReading(loggedInUser, reading.getReadingName(), readingName);
    }

    public void clearLog() {
        actions.removeLog(loggedInUser);
    }

    public boolean deleteReading(String readingName) {
        return actions.discardReading(loggedInUser, readingName);
    }

    public boolean renameReading(String oldName, String newName) {
        return actions.nameReading(loggedInUser, oldName, newName);
    }

    public String viewReadingLog() {
        return loggedInUser.getReadingLog().toString();
    }
}
