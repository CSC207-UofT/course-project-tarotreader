package entities;
import java.util.HashMap;
import java.util.Map;
import entities.Reading;

public class ReadingLog {
    private Map<String, Reading> readings;
    private User belongingUser;

    public ReadingLog(User user) {
        this.belongingUser = user;
        this.readings = new HashMap<String, Reading>();
    }

    public Map<String, Reading> getReadings() {
        return this.readings;
    }

    public void addToLog(Reading reading) {
        readings.put(reading.readingName, reading);
    }

    @Override
    public String toString() {
        StringBuilder logs = new StringBuilder();
        for (Reading reading: readings.values()) {
            logs.append(reading.toString());
            logs.append("\n");
        }
        return logs.toString();
    }
}
