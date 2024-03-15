import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String city;
    private LocalDate start, end;
    private List<Attraction> attractions = new ArrayList<>();

    public Trip(){

    }

    public String getCity() {
        return city;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        StringBuilder toReturn;
        toReturn = new StringBuilder("Calatoria mea incepe pe " + this.start + " ,merg sa vizitez " + this.city + " ,ma voi intoarce pe " + this.end + " si ma voi plimba pe la ");
        for(int i = 0; i < attractions.size(); i++){
            toReturn.append(attractions.get(i).getTip()).append(" ");
            toReturn.append(attractions.get(i).getName()).append(" , ");
        }
        return toReturn.toString();
    }

}
