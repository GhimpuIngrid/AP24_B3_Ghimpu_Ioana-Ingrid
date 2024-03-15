import java.time.LocalDate;
import java.util.Map;

public class Statue extends Attraction{

    private kind tip;
    public Statue(){
        this.tip = kind.STATUIA;
    }

    public kind getTip() {
        return tip;
    }
}
