package entities;
import useCases.TarotReader;
import java.util.List;
import java.util.ArrayList;
import entities.Reading;

public class ReadingLog {
    private List<Reading> readings;
    private User belongingUser;

    public ReadingLog(User user) {
        this.belongingUser = user;
        this.readings = new ArrayList<Reading>();
    }

    public List<Reading> getReadings() {
        return this.readings;
    }

    public void addToLog(Reading reading) {
        readings.add(reading);
    }

    @Override
    public String toString() {
        StringBuilder logs = new StringBuilder();
        for (Reading reading: readings) {
            logs.append(reading.toString());
            logs.append("\n");
        }
        return logs.toString();
    }
}
