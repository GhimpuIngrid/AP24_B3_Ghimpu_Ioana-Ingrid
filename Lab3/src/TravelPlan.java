import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TravelPlan {
    public void createTravelPlan(Trip t){
        List<Attraction> attractions = new ArrayList<>();
        attractions = t.getAttractions();

        LocalDate start = t.getStart();
        LocalDate end = t.getEnd();

        for(LocalDate date = start;date.isBefore(end); date = date.plusDays(1)) {
            int ok = 0;
            for (int i = 0; i < attractions.size() && ok == 0; i++) {
                for (LocalDate key : (attractions.get(i).getTimeTable().keySet())) {
                    if (key.isEqual(date) && !attractions.get(i).getVisited()) {
                        System.out.println("In ziua " + date + " voi vizita " + attractions.get(i).getName());
                        ok = 1;
                        attractions.get(i).setVisited(true);
                        break;
                    }
                }
            }
        }
    }
}
