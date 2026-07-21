package dailycode.july20.Parking;

public class Auto extends Vehicle{
    public Auto(String vehicleNumber, String ownerName, String entryTime) {
        super(vehicleNumber, ownerName, entryTime);
    }

    @Override
    void calculateParkingFee() {
        System.out.println("Pay Entry fess");
        System.out.println("Entry Fess is 50rs ");
        double fixedPrice=50;
        double  parkRent=60;
        fixedPrice=parkRent+fixedPrice;
        System.out.println("Auto Parking Fess is  Rs 60 : ");

        System.out.println("Your Final Amount "+fixedPrice);




    }

    @Override
    String vehicleType() {

        return "Auto";
    }
}
