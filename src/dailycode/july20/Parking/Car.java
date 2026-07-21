package dailycode.july20.Parking;

public class Car extends Vehicle {

    public Car(String vehicleNumber, String ownerName, String entryTime) {
        super(vehicleNumber, ownerName, entryTime);
    }

    @Override
    void calculateParkingFee() {
        System.out.println("Pay Entry fess");
        System.out.println("Entry Fess is 50rs ");
        double fixedPrice=50;
        double  parkRent=120;
        fixedPrice=parkRent+fixedPrice;
        System.out.println("Car  Parking Fess is  Rs 120 : ");

        System.out.println("Your Final Amount "+fixedPrice);




    }

    @Override
    String vehicleType() {
        return "Car";
    }
}