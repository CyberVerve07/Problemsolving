package dailycode.july16.OlaRideBooking;

public class Cab extends Ride{


    public Cab(String customerName,  float distance) {
        super(customerName,  distance);
    }

    @Override
    void calFare() {
        super.calFare();
        float fare = getDistance() * 30;

        System.out.println(" Ac Cab Service: " +
                "");
        System.out.println(" Your Fare is ::"+fare);
    }
}

