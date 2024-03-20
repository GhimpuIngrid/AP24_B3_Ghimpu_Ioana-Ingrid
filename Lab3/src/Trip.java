import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trip {
    private String city;
    private LocalDate start, end;
    private List<Attraction> attractions = new ArrayList<>();
    private List<Attraction> visitable = new ArrayList<>();

    public Trip(){}

    public Trip(LocalDate start, LocalDate end){
        this.start = start;
        this.end = end;
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

    public List<Attraction> getVisitable(LocalDate date){

        this.visitable.clear();

        for(int i = 0; i < this.attractions.size(); i++){
            if(!(this.attractions.get(i) instanceof Payable))
                if(this.attractions.get(i).getTimeTable() != null)
                    this.visitable.add(this.attractions.get(i));
        }

        this.visitable.sort(new AttractionComparator(date));

        return this.visitable;

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

    public void addAttraction(Attraction a){
        this.attractions.add(a);
    }

    @Override
    public String toString() {
        StringBuilder toReturn;
        toReturn = new StringBuilder("Calatoria mea incepe pe " + this.start + " ,merg sa vizitez " + this.city + " ,ma voi intoarce pe " + this.end + " si ma voi plimba pe la ");
        for(int i = 0; i < attractions.size(); i++){
            toReturn.append(attractions.get(i).getName()).append(" , ");
        }
        return toReturn.toString();
    }

}
