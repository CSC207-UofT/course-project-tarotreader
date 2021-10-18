package inputs;

import entities.*;
import useCases.TarotReader;
import controllers.ReadingLogManager;

public class LogReading {
    private static final String LOG_COMMAND = "log";

    public static void log(User user, TarotReader reading) {
        ReadingLogManager.logReading(user, reading);
    }

}
