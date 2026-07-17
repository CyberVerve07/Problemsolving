package dailycode.july17.Code1.Notification;

public class MAin {
    public static void main(String[] args) {

          Process noty=new Process();
           Notification send=new Sms("Amazon");
           Notification send2=new EmailNotificaation("Flipkart");
            Notification send3=new WhatsappNotification("Flipkart");
             Notification send4=new Push("Zomato");

               noty.noty(send);
               noty.noty(send2);
               noty.noty(send3);
               noty.noty(send4
               );




    }
}
