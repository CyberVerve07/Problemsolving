package transport;

public class Execute {
    public static void main(String[] args) {


        Scooty sc = new Scooty("Sakharam", 7873, 2024, "Hero", "Red", "20k");
        sc.showDetails();
        Car c = new Car("Aulto", 2016, 2023, "HondaCity", 4, "Good");
       c.startCar();
    }}