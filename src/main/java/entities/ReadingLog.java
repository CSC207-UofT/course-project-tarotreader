package entities;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import entities.Reading;

public class ReadingLog implements Serializable {
    //Holds all users and their related HashMap of String names and Readings for each user.
    private HashMap<String, Reading> readings;


    public ReadingLog() {
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
