import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Statue extends Attraction{

    protected String name;
    protected boolean visited;

    public Statue(String name){
        this.name = name;
        this.visited = false;
    }

    @Override
    public String getName(){return this.name;}



    @Override
    public HashMap<LocalDate, Pair<LocalTime, LocalTime>> getTimeTable() {
        return this.timeTable;
    }
}
