import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, Pair<LocalTime, LocalTime>> getTimeTable();
    public default int getOpeningHours(LocalDate date){
        return this.getTimeTable().get(date).getFirst().getHour();
    }

}
