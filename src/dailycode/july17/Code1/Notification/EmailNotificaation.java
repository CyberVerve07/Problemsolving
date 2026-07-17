package dailycode.july17.Code1.Notification;

public class EmailNotificaation extends Notification {

    public EmailNotificaation(String companyName) {
        super(companyName);
    }

    @Override
    void sendNotification() {
        System.out.println("=====================================");

        System.out.println("Email is Send on Email Please Check ");

        System.out.println(" Hi Amazon user your Order is Successfully Dispatch ");

        System.out.println("==========================================");

    }

}
