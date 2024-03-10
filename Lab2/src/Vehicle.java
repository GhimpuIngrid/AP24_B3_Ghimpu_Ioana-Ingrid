public class Vehicle {
    private String name;
    private String type;
    private Depot depotName;

    public Vehicle(){

    }

    public Vehicle(String name, String type, Depot depotName){

        this.name = name;
        this.type = type;
        this.depotName = depotName;
        this.depotName.addVehicle(this);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(){
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public Depot getDepot(){
        return this.depotName;
    }

    public void changeDepot(Depot newDepotName){
        this.depotName.removeVehicle(this);
        this.depotName= newDepotName;
        this.depotName.addVehicle(this);
    }

    @Override
    public String toString(){
        return "Vehicle name: " + this.name + '\n' + "Vehicle type: " +
                this.type + '\n' + "Vehicle belongs to " + this.depotName.getName() + " depot" + '\n';
    }
}
