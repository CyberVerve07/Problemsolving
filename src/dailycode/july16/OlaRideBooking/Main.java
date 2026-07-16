package dailycode.july16.OlaRideBooking;

public class Main {
    public static void main(String[] args) {

           Calfare calfare=new Calfare();

           Ride bike=new Bike("Aditya",5);
            Ride cab=new Cab("Rahul",15);
        calfare.cal(bike);
        calfare.cal(cab);
    }
}
