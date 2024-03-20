import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

abstract class Attraction implements Visitable{

    public HashMap<LocalDate, Pair<LocalTime, LocalTime>> timeTable = new HashMap<>() ;
    public String name;
    public boolean visited;

    public String getName() {
        return this.name;
    }

    public void setTimeTable(int year, int month, int day, int firstHour, int firstMinute, int secondHour, int secondMinute){
        LocalDate date = TimeTableGen.generateDate(year, month, day);
        Pair<LocalTime, LocalTime> pair = TimeTableGen.generateInterval(firstHour, firstMinute, secondHour, secondMinute);
        this.timeTable.put(date, pair);
    }

    public boolean getVisited(){return this.visited;}
    public void setVisited(boolean a){this.visited = a;}

    @Override
    public String toString(){
        StringBuilder toReturn;
        toReturn = new StringBuilder(this.name + " attraction can be visited on : ");
        for(LocalDate key : (this.getTimeTable().keySet()))
            toReturn.append(key + " between hours: " + this.getTimeTable().get(key).getFirst().getHour() + "." +
                    this.getTimeTable().get(key).getFirst().getMinute() + " and " +
                    this.getTimeTable().get(key).getSecond().getHour() + "." +
                    this.getTimeTable().get(key).getFirst().getMinute() + '\n');

        return toReturn.toString();
    }
}
