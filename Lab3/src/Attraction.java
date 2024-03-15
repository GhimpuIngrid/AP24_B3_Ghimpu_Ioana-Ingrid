public class Attraction{
    protected String name;
    private kind tip;
    public enum kind {STATUIA, BISERICA, CONCERTUL; }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public kind getTip() {
        return tip;
    }
}
