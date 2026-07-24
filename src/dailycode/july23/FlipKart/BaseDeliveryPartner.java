package dailycode.july23.FlipKart;

public  abstract class BaseDeliveryPartner  implements DeliveryPartner {

     //Abstract class for Delivery Partner :::::::::::::::

       private  int partnerId;

      private  String  partnerName;

       private  int  vehicleNumber;

       private  int  rating;

   private String  location;

   //These are the PPrivate Fields  Used in Abstract class for Delivery rider info

//Crete the Constructor for initializing the values
    public BaseDeliveryPartner(int partnerId, String partnerName, int vehicleNumber, int rating, String location) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.vehicleNumber = vehicleNumber;
        this.rating = rating;
        this.location = location;
    }

        //Generate Getters and Setters :::::::::::::::::::::::::::::::


    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


                //Generate the Methods :::::: show profile is a Concrete Method:

      public void showInfo(){
          System.out.println("::::::::::::::::::::::::::::::::::::::::");
          System.out.println("Your Order Details are::");
          System.out.println("Delivery Partner name is ::" +getPartnerName());
          System.out.println("Item ID Product is is "+getPartnerId());
          System.out.println("Vehicle number is :: "+getVehicleNumber());
          System.out.println("Location is :"+getLocation());
          System.out.println("Rating of your Product are ::::: "+getRating());
          System.out.println("=============================================");
          System.out.println();


      }
        public  void updatelocation(){

        }




}
