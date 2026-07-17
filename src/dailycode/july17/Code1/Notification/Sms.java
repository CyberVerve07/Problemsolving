package dailycode.july17.Code1.Notification;

public class Sms extends  Notification{
    public Sms(String companyName) {
        super(companyName);
    }

    @Override
    void sendNotification() {

        System.out.println("======================================================");
        System.out.println("Your Refund is Credit in your Bank account XXX2930XX93");
        System.out.println("Thank You:");
        System.out.println("=======================================================");

    }
}
