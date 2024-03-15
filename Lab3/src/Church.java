import java.time.LocalDate;
import java.util.Map;

public class Church extends Attraction implements Visitable{

    private kind tip;
    public Church(){
        this.tip = kind.BISERICA;
    }
    @Override
    public Map<LocalDate, TimeInterval> getTimeTable() {
        return null;
    }

    @Override
    public LocalDate getOpeningHour(LocalDate date) {
        return null;
    }

    public kind getTip() {
        return tip;
    }
}
