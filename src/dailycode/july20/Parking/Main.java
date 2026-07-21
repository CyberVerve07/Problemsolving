package dailycode.july20.Parking;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle=new Bike("420;","Nikshay","3:20Pm");
        Vehicle vehicle1=new Car("8304","Ashish","9:00AM");
        Vehicle vehicle2=new Auto("9302","Aditya","3:00");

 Vehicle.companyInfo();

         vehicle.displayTicket();
         vehicle.calculateParkingFee();

          vehicle1.displayTicket();
        //  vehicle1.vehicleType();
          vehicle1.calculateParkingFee();

           vehicle2.displayTicket();
      //     vehicle2.vehicleType();
           vehicle2.calculateParkingFee();
    }
}
