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
            myFisrtTrip.setStart(LocalDate.of(2022, 3, 20));
            myFisrtTrip.setEnd(LocalDate.of(2022, 3,25));

            Statue statue1 = new Statue("Alexandru Ioan Cuza");
            Statue statue2 = new Statue("Alexandru Ioan Cuza2");
            Statue statue3 = new Statue("Alexandru Ioan Cuza3");
            Church church1 = new Church("Mitropolie");
            Church church2 = new Church("Mitropolie2");
            Church church3 = new Church("Mitropolie3");
            Concert concert1 = new Concert("AAA");
            Concert concert2 = new Concert("BBB");
            Concert concert3 = new Concert("CCC");

            List<Attraction> attractions = new ArrayList<>();
            attractions.add(statue1);
            attractions.add(church1);
            attractions.add(concert1);

            myFisrtTrip.setAttractions(attractions);
            myFisrtTrip.addAttraction(statue2);
            myFisrtTrip.addAttraction(statue3);
            myFisrtTrip.addAttraction(church2);
            myFisrtTrip.addAttraction(church3);
            myFisrtTrip.addAttraction(concert2);
            myFisrtTrip.addAttraction(concert3);

            church1.setTimeTable(2022, 3, 21, 8, 0, 20, 0);
            church1.setTimeTable(2022, 3, 22, 8, 0, 20, 0);
            church1.setTimeTable(2022, 3, 23, 8, 0, 20, 0);

            church2.setTimeTable(2022, 3, 21, 10, 0, 20, 0);
            church2.setTimeTable(2022, 3, 22, 10, 0, 20, 0);
            church2.setTimeTable(2022, 3, 23, 9, 0, 20, 0);

            church3.setTimeTable(2022, 3, 21, 9, 30, 20, 0);
            church3.setTimeTable(2022, 3, 22, 12, 30, 20, 0);
            church3.setTimeTable(2022, 3, 23, 9, 30, 20, 0);

            concert1.setTimeTable(2022, 3, 21, 19, 0, 21, 0);
            concert2.setTimeTable(2022, 3, 22, 18, 30, 20, 30);
            concert3.setTimeTable(2022, 3, 22, 18, 0, 20, 0);

            statue1.setTimeTable(2022, 3, 21, 1, 0, 23, 0);
            statue1.setTimeTable(2022, 3, 22, 1, 0, 23, 0);
            statue1.setTimeTable(2022, 3, 23, 1, 0, 23, 0);
            statue1.setTimeTable(2022, 3, 24, 1, 0, 23, 0);

            statue2.setTimeTable(2022, 3, 24, 1, 0, 23, 0);
            statue3.setTimeTable(2022, 3, 24, 1, 0, 23, 0);



            TravelPlan plan= new TravelPlan();

            plan.createTravelPlan(myFisrtTrip);

        //System.out.println(myFisrtTrip);
    }
}