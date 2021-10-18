package entities;
import useCases.TarotReader;
import java.util.List;
import java.util.ArrayList;

public class ReadingLog {
    private List<TarotReader> readings;
    private User belongingUser;

    public ReadingLog(User user) {
        this.belongingUser = user;
        this.readings = new ArrayList<TarotReader>();
    }

    public List<TarotReader> getReadings() {
        return this.readings;
    }

    public void addToLog(TarotReader reading) {
        readings.add(reading);
    }

    @Override
    public String toString() {
        StringBuilder logs = new StringBuilder();
        for (TarotReader reading: readings) {
            logs.append(reading.toString());
            logs.append("\n");
        }
        return logs.toString();
    }
}
