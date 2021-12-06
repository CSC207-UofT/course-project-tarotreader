package inputs;

import entities.*;
import useCases.ReadingLogActions;

public class LogReading {
    private static final String LOG_COMMAND = "log";

    public static void log(User user, Reading reading) {
        ReadingLogActions.logReading(user, reading);
    }

}
