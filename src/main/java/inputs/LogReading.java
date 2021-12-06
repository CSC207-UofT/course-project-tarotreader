package inputs;

import entities.*;
import useCases.ReadingLogManager;

public class LogReading {
    private static final String LOG_COMMAND = "log";

    public static void log(User user, Reading reading) {
        ReadingLogManager manager = new ReadingLogManager();
        manager.logReading(user, reading);
    }

}
