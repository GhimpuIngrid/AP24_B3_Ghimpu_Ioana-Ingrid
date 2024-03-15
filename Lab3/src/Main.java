import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Trip myFisrtTrip = new Trip();
            myFisrtTrip.setCity("Iasi");
            myFisrtTrip.setStart(LocalDate.of(2020, 6, 13));
            myFisrtTrip.setEnd(LocalDate.of(2020, 6,20));

            Statue statue = new Statue();
            statue.setName("Alexandru Ioan Cuza");
            Church church = new Church();
            church.setName("Mitropolie");
            Concert concert = new Concert();
            concert.setName("AAA");

            List<Attraction> attractions = new ArrayList<>();
            attractions.add(statue);
            attractions.add(church);
            attractions.add(concert);

            myFisrtTrip.setAttractions(attractions);
        System.out.println(myFisrtTrip);
    }
}