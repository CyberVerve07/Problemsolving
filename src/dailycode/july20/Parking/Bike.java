package dailycode.july20.Parking;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber, String ownerName, String entryTime) {
        super(vehicleNumber, ownerName, entryTime);
    }

    @Override
    void calculateParkingFee() {
        System.out.println("Pay Entry fess");
        System.out.println("Entry Fess is 50rs ");
         double fixedPrice=50;
          double  parkRent=20;
           fixedPrice=parkRent+fixedPrice;


        System.out.println("Bike Parking Fess is  Rs 20 : ");


        System.out.println("Total Ammount is "+fixedPrice);








    }

    @Override
    String vehicleType() {

        System.out.println("Vehicle type is " + vehicleType());


        return "Bike";
    }
}
