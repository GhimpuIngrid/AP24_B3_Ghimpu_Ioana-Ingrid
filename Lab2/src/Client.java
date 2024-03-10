public class Client {
    public enum Type{REGULAR, PREMIUM};
    private String name;
    private int timePeriodStart;
    private int timePeriodFinish;
    private Type clientType;
    public Client(){

    }
    public Client(String name, int timePeriodStart, int timePeriodFinish, Type clientType){
        if(timePeriodFinish <= timePeriodStart){
            System.out.println("Timpul de inceput trebuie sa fie mai mic (mai devreme) decat timpul de final");
        }

        else{
            this.name = name;
            this.timePeriodStart = timePeriodStart;
            this.timePeriodFinish = timePeriodFinish;
            this.clientType = clientType;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTimePeriod(int timePeriodStart, int timePeriodFinish){
        this.timePeriodStart = timePeriodStart;
        this.timePeriodFinish = timePeriodFinish;
    }

    public String getName(){
        return this.name;
    }

    public int getStartTime(){
        return this.timePeriodStart;
    }

    public int getFinishTime(){
        return this.timePeriodFinish;
    }

    @Override
    public String toString(){
        return "Client name: " + this.name + '\n' + "Client status: " + this.clientType +
                '\n' + "Client wants to be taken at " + this.timePeriodStart +
                " o'clock and wants to pe left at destination at " + this.timePeriodFinish + " o'clock." + '\n';

    }
}
