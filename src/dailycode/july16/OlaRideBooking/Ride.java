package dailycode.july16.OlaRideBooking;

public class Ride {
         private  String customerName;
         // private  double fare;

    public Ride(String customerName,  float distance) {
        this.customerName = customerName;
    //    this.fare = fare;
        this.distance = distance;
    }




    private float distance ;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
         if (customerName!=null) {
             this.customerName = customerName;
         }
         else {
             System.out.println("Enter Customer name:");
         }
    }

    //public double getFare() {
       // return fare;
  //  }

   // public void setFare(double fare) {
 //       this.fare = fare;
    //}

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
         if (distance<0) {
             this.distance = distance;
         }else {
             System.out.println("Enter the distance ");
         }
    }
     void  calFare(){
         System.out.println(" Fare is Calcuating ...");
     }

}
