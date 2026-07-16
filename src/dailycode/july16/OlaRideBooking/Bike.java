package dailycode.july16.OlaRideBooking;

public class Bike extends Ride{

    public Bike(String customerName,  float distance) {
        super(customerName,  distance);
    }

    @Override
    void calFare() {
        super.calFare();
         float fare=getDistance()*15;
        System.out.println(" Your Fair is: "+fare);
    }
}
