package useCases;

import entities.User;
import entities.Reading;
import entities.ReadingLog;

public class ReadingLogger {

    private User loggedInUser;

    public ReadingLogger(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void logReading(Reading reading) {
       ReadingLog readingLog = loggedInUser.getReadingLog();
       readingLog.addToLog(reading);
    }

    public void deleteReading(Reading reading) {
        //loggedInUser.getReadingLog().deleteReading(reading);
        //TODO: Implement delete reading in ReadingLog
    }
}

