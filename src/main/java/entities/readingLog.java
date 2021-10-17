package entities;
import useCases.tarotReader;
import java.util.List;
import java.util.ArrayList;

public class readingLog {
    private List<tarotReader> readings;

    /**
     * Constructs a new reading log
     */
    public readingLog() {
        this.readings = new ArrayList<tarotReader>();
    }

    /**
     * Getter method for the readings
     * @return Returns list of readings for this user log.
     */
    public List<tarotReader> getReadings() {
        return this.readings;
    }

    /**
     * Adds the reading to this log
     * @param reading the tarot reading to add
     */
    public void addToLog(tarotReader reading) {
        readings.add(reading);
    }

    /**
     * Override toString method
     * @return A string representation of all the readings in the reading log.
     */
    @Override
    public String toString() {
        StringBuilder logs = new StringBuilder();
        for (tarotReader reading: readings) {
            logs.append(reading.toString());
            logs.append("\n");
        }
        return logs.toString();
    }
}
