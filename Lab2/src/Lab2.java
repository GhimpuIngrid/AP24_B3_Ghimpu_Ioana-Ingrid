public class Lab2 {
    public static void main(String[] args) {
        Compulsory();
    }

    public static void Compulsory(){
        Depot depot = new Depot("Nume1");
        Vehicle car = new Vehicle("Masina1", "D2024", depot);
        Client client = new Client("Ingrid", 2, 3, Client.Type.PREMIUM);
        Client client2 = new Client();

        System.out.println(depot);
        System.out.println(car);
        System.out.println(client);
    }

}
