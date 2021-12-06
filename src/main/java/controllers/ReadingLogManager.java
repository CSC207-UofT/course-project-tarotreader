package controllers;

import entities.User;
import entities.Reading;
import entities.ReadingLog;
import java.util.Scanner;

public class ReadingLogManager {

    private final User loggedInUser;

    //Creates a ReadingLogger object with the logged in User.
    public ReadingLogManager(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }



    /**
     * Adds the reading generated to the user's reading log.
     * @param reading Reading to log
     * @param readingName Name of the reading
     */
    public void logReading(Reading reading, String readingName) {

        reading.setReadingName(readingName);
        ReadingLog readingLog = loggedInUser.getReadingLog();
        readingLog.addToLog(reading);
    }
}

