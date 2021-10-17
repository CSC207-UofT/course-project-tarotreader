package inputs;

import entities.*;
import useCases.tarotReader;
import controllers.readingLogManager;

public class logReading {
    private static final String LOG_COMMAND = "log";

    public static void log(user user, tarotReader reading) {
        readingLogManager.logReading(user, reading);
    }

}
