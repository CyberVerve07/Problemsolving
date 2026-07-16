package dailycode.july16.ZeptoDeliverySystem;

public class Main {
    public static void main(String[] args) {

          Process b=new Process();

            DeliveryPartner deliveryPartner1=new Bike("Aditya",123);
             DeliveryPartner deliveryPartner2=new Cycle("Rahul",137);
              DeliveryPartner deliveryPartner3=new Ebay("Harsh",898);

 b.assignDelivery(deliveryPartner1);
 b.assignDelivery(deliveryPartner2);
 b.assignDelivery(deliveryPartner3);

    }
}
