package controllers;
import entities.Reading;
import entities.ReadingLog;
import entities.User;

import java.util.HashMap;
import java.util.Map;


public class ReadingLogManager {
    private static final Map<User, ReadingLog> logs = new HashMap<>();
    private static Reading reading;

    // If the user does not have a reading log, returns null.
    public static ReadingLog viewLog(User user, String readingName) {
        ReadingLog log = null;
        if (logs.containsKey(user)) {
            log = logs.get(user);
        }
        //*assert log != null;
        //*if (log.readings.containsKey(readingName)) {
        //    reading = log.readings.get(readingName);
        //}
        return log;
    }

    // Returns true if the reading is successfully added to the log, false otherwise.
    public static boolean logReading(User user, Reading reading) {
        if (logs.containsKey(user)) {
            logs.get(user).addToLog(reading);
            return true;
        }
        return false;
    }

    public static void addLog(User user) {
        logs.put(user, user.getReadingLog());
    }

    public static boolean remove_log(User user) {
        if (logs.containsKey(user)) {
            logs.get(user).addToLog(reading);
            return true;
        }
        return false;
    }
    }


