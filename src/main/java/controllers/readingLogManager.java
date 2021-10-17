package controllers;
import entities.readingLog;
import entities.user;
import useCases.tarotReader;

import java.util.HashMap;
import java.util.Map;


public class readingLogManager {
    private static Map<user, readingLog> logs = new HashMap<user, readingLog>();

    /**
     * Returns the log of the selected user
     * @param user Selected user
     * @return ReadingLog object of the given user. If the user does not have a reading log, returns null.
     */
    public static readingLog viewLog(user user) {
        readingLog log = null;
        if (logs.containsKey(user)) {
            log = logs.get(user);
        }
        return log;
    }

    /**
     * Adds the reading to the log of the specified user.
     * @param user The specified user
     * @param reading A tarot reading
     * @return Returns true if the reading is successfully added to the log, false otherwise.
     */
    public static boolean logReading(user user, tarotReader reading) {
        if (logs.containsKey(user)) {
            logs.get(user).addToLog(reading);
            return true;
        }
        return false;
    }

    /**
     * Adds the user and the user's reading log to the logs map.
     * @param user The specified user object.
     */
    public static void addLog(user user) {
        logs.put(user, user.getReadingLog());
    }

}

