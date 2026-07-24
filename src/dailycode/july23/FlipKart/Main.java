package dailycode.july23.FlipKart;

public class Main {
    public static void main(String[] args) {

         BaseDeliveryPartner deliver=new Bike(7292,"Aditya",4789,3,"BTM");

          deliver.acceptOrder();
          deliver.pickupOrder();
          deliver.deliverOrder();
    }
}
