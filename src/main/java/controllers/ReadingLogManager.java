package controllers;
import entities.ReadingLog;
import entities.User;
import useCases.TarotReader;

import java.util.HashMap;
import java.util.Map;


public class ReadingLogManager {
    private static Map<User, ReadingLog> logs = new HashMap<User, ReadingLog>();

    // If the user does not have a reading log, returns null.
    public static ReadingLog viewLog(User user) {
        ReadingLog log = null;
        if (logs.containsKey(user)) {
            log = logs.get(user);
        }
        return log;
    }

    // Returns true if the reading is successfully added to the log, false otherwise.
    public static boolean logReading(User user, TarotReader reading) {
        if (logs.containsKey(user)) {
            logs.get(user).addToLog(reading);
            return true;
        }
        return false;
    }

    public static void addLog(User user) {
        logs.put(user, user.getReadingLog());
    }

}
