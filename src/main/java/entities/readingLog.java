package entities;
import useCases.tarotReader;
import java.util.List;
import java.util.ArrayList;

public class readingLog {
    private List<tarotReader> readings;
    private user belongingUser;

    public readingLog(user user) {
        this.belongingUser = user;
        this.readings = new ArrayList<tarotReader>();
    }

    public List<tarotReader> getReadings() {
        return this.readings;
    }

    public void addToLog(tarotReader reading) {
        readings.add(reading);
    }

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
