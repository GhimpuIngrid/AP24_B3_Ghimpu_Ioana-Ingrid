import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Church extends Attraction{

    protected String name;
    protected boolean visited;
    public Church(String name){
        this.name = name;
        this.visited = false;
    }
    @Override
    public String getName(){return this.name;}

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getTimeTable() {
        return this.timeTable;
    }
}
