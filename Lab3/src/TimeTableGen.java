import java.time.LocalDate;
import java.time.LocalTime;

public class TimeTableGen {
    public static LocalDate generateDate(int year, int month, int day){
        LocalDate date = null;
        date = LocalDate.of(year, month, day);

        return date;
    }

    public static Pair<LocalTime, LocalTime> generateInterval(int firstHour, int firstMinute, int secondHour, int secondMinute){
        Pair<LocalTime, LocalTime> interval = new Pair<>(null, null);
        interval.setFirst(LocalTime.of(firstHour, firstMinute));
        interval.setSecond(LocalTime.of(secondHour,secondMinute));

        return interval;
    }
}
