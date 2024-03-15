public class Concert extends Attraction implements Payable{

    private kind tip;

    public Concert(){
        this.tip = kind.CONCERTUL;
    }
    @Override
    public double getTicketPrice() {
        return 0;
    }

    public kind getTip() {
        return tip;
    }
}
