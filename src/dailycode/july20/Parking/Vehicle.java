package dailycode.july20.Parking;

//Problem Statement
//
//Build a Console-Based Smart Parking System where different types of vehicles enter a parking lot. The system should calculate parking charges, display vehicle information, and generate parking tickets.
//
//Use only Core Java OOP.
public abstract class Vehicle  {

    public Vehicle(String vehicleNumber, String ownerName, String entryTime) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.entryTime = entryTime;
    }

    //vehicleNumber
    //ownerName
    //entryTime
     private  String  vehicleNumber;
      private  String ownerName;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
         if (vehicleNumber==null) {
             System.out.println("Please Enter the Vehicle number : ");
         }
          else {
             this.vehicleNumber = vehicleNumber;
         }

    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
         if ( ownerName ==null){
             System.out.println("Please Enter the Owner Name:");
         }
         else {
             this.ownerName = ownerName;
         }
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    private  String entryTime;


    //companyInfo() static method for print the  Info
     static  void  companyInfo(){
         System.out.println("Welcome to the Ground You can Park your vehicle with full Security:: ");
         System.out.println("Have a nice day :");


     }
         //Final method for  printing the details

      final  void  displayTicket(){
          System.out.println("======================");
          System.out.println("Owner name is :"+getOwnerName());
          System.out.println("The Vehicle number is : "+getVehicleNumber());
          System.out.println("Timing of parking the Vehicle is "+getEntryTime());
          System.out.println("============================");
      }

           //Abstraction Method is :
     abstract  void  calculateParkingFee();

       abstract  String  vehicleType();


}
