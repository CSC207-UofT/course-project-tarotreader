package inputs;

import entities.*;
import controllers.ReadingLogManager;

public class LogReading {
    private static final String LOG_COMMAND = "log";

    public static void log(User user, Reading reading) {
        ReadingLogManager.logReading(user, reading);
    }

}
