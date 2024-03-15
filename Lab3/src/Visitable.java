import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimeTable();
    LocalDate getOpeningHour(LocalDate date);

}
