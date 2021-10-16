package controllers;
import entities.readingLog;
import entities.user;
import useCases.tarotReader;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


public class ReadingLogManager {
    private static Map<user, readingLog> logs = new HashMap<user, readingLog>();

    // If the user does not have a reading log, returns null.
    public static readingLog viewLog(user user) {
        readingLog log = null;
        if (logs.containsKey(user)) {
            log = logs.get(user);
        }
        return log;
    }

    // Returns true if the reading is successfully added to the log, false otherwise.
    public static boolean logReading(user user, tarotReader reading) {
        if (logs.containsKey(user)) {
            logs.get(user).addToLog(reading);
            return true;
        }
        return false;
    }

    public static void addLog(user user) {
        logs.put(user, user.getReadingLog());
    }

}

