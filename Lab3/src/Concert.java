import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Concert extends Attraction implements Payable{

    protected String name;
    protected boolean visited;

    public Concert(String name){
        this.name = name;
        this.visited = false;
    }
    @Override
    public double getTicketPrice() {
        return 0;
    }

    @Override
    public String getName(){return this.name;}

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getTimeTable() {
        return this.timeTable;
    }
}
