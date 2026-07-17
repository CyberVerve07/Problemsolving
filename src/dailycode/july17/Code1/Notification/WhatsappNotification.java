package dailycode.july17.Code1.Notification;

public class WhatsappNotification  extends Notification{
    public WhatsappNotification(String companyName) {
        super(companyName);
    }

    @Override
    void sendNotification() {
        System.out.println("======================================================");
        System.out.println("Don't miss the Great Indian biggest festival is hear ");

        System.out.println("Shop Now ::::::::::::::::::::;; ");

        System.out.println("=========================================================");

    }
}
