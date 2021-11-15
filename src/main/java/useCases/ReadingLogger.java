package useCases;

import entities.User;
import entities.Reading;
import entities.ReadingLog;

public class ReadingLogger {

    private User loggedInUser;

    //Creates a ReadingLogger object with the logged in User.
    public ReadingLogger(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //Adds the reading generated to the user's reading log.
    public void logReading(Reading reading) {
        //*
         // @param reading: The Reading object generated and to be added to the user's reading log.
         //
        ReadingLog readingLog = loggedInUser.getReadingLog();
        readingLog.addToLog(reading);
    }
}

