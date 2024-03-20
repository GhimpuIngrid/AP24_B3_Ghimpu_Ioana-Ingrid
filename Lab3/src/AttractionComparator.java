import java.time.LocalDate;
import java.util.Comparator;

public class AttractionComparator implements Comparator<Attraction> {
    LocalDate key = null;

    public AttractionComparator(LocalDate date){
        key = date;
    }

    @Override
    public int compare(Attraction a, Attraction b) {
        return a.getTimeTable().get(key).getFirst().getHour() - b.getTimeTable().get(key).getFirst().getHour();
    }
}
