package dailycode.july16.OlaRideBooking;

public class Auto extends Ride {
    public Auto(String customerName,  float distance) {
        super(customerName, distance);
    }

    @Override
    void calFare() {
        super.calFare();
         float fare =getDistance()*21;
        System.out.println(" Your Fair is : "+fare);
    }
}
