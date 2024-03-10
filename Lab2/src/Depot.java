import java.util.Objects;

public class Depot {
    private String name;
    private Vehicle[] cars;
    private int numberOfCars;

    public Depot(){

    }

    public Depot(String name){
        this.name = name;
        numberOfCars = 0;
        this.cars = new Vehicle[100];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addVehicle(Vehicle car){
        this.cars[numberOfCars] = car;
        this.numberOfCars++;
    }

    public void removeVehicle (Vehicle car){
        int carNumber = this.searchVehicle(car);

        for(int i = carNumber; i < this.numberOfCars - 1; i++){
            this.cars[i] = this.cars[i+1];
        }
    }

    public int searchVehicle(Vehicle car){
        int carNumber = -1;
        for(int i = 0; i < this.numberOfCars; i++){
            if(Objects.equals(this.cars[i].getName(), car.getName()) && Objects.equals(this.cars[i].getType(), car.getType())){
                carNumber = i;
                break;
            }
        }
        return carNumber;
    }

    @Override
    public String toString(){
        return "Depot name: " + this.name + '\n' + "Number of vehicles in depot: " + this.numberOfCars + '\n';
    }
}
