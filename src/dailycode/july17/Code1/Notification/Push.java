package dailycode.july17.Code1.Notification;

public class Push extends Notification{

    public Push(String companyName) {
        super(companyName);
    }

    @Override
    void sendNotification() {
        System.out.println("===============================");
        System.out.println("Notification is Push ");
        System.out.println("OTP is _-_-_--_");
        System.out.println("==================================");

    }
}
