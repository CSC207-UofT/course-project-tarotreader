package useCases;
import entities.Reading;
import entities.ReadingLog;
import entities.User;

import java.util.HashMap;
import java.util.Map;


public class ReadingLogActions {

    // If the user does not have a reading log, returns null.
    public ReadingLog viewLog(User user) {
        return user.getReadingLog();
    }

    public String viewReading(User user, String name) {
        ReadingLog log = user.getReadingLog();
        assert log != null;
        Map<String, Reading> readings = log.getReadings();
        if (readings.containsKey(name)){
            Reading selected = readings.get(name);
            return selected.toString();
        }
        else{
            return "Reading does not exist";
        }
    }

    // Returns true if the reading is successfully added to the log, false otherwise.
    public void logReading(User user, Reading reading) {
        ReadingLog log = user.getReadingLog();
        log.addToLog(reading);
    }

    public void removeLog(User user) {
        ReadingLog log = user.getReadingLog();
        Map<String, Reading> readings = log.getReadings();
        readings.clear();
    }

    public boolean discardReading(User user, String readingName) {
        ReadingLog log = user.getReadingLog();
        Map<String, Reading> readings = log.getReadings();
        if (readings.containsKey(readingName)) {
            readings.remove(readingName);
            return true;
        } else {
            return false;
        }
    }

    public boolean nameReading(User user, String readingName, String newReadingName) {
        if (user.getReadingLog().getReadings().containsKey(readingName)) {
            user.getReadingLog().getReadings().get(readingName).setReadingName(newReadingName);
            return true;
        }
        return false;
    }
}

