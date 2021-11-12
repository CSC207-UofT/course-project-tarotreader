package controllers;
import entities.Reading;
import entities.ReadingLog;
import entities.User;
import useCases.TarotReader;

import java.util.HashMap;
import java.util.Map;


public class    ReadingLogManager {
    private static final Map<User, ReadingLog> logs = new HashMap<>();

    // If the user does not have a reading log, returns null.
    public static ReadingLog viewLog(User user) {
        ReadingLog log = null;
        if (logs.containsKey(user)) {
            log = logs.get(user);
        }
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

    public static void remove_log(User user) {
        logs.remove(user);
        /* As our keys are user we need to figure at a way to distinct the keys to be able to delete a specific log.*/
    }
}

