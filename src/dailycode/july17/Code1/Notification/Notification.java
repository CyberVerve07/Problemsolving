package dailycode.july17.Code1.Notification;

//Problem Statement
//
//You are developing a Notification Module for an e-commerce application like Amazon.
//
//Whenever a user places an order, the system can send notifications through different channels:
//
//📧 Email
//📱 SMS
//💬 WhatsApp
//🔔 Push Notification
//
//Each notification has a different implementation, but every notification must support sending a me
public abstract class Notification {

    String companyName;

    public Notification(String companyName) {
        System.out.println("Notification Service is Start: ");
        this.companyName = companyName;
    }



    void displayInfo() {
        System.out.println("Amazon:");

    }
          abstract void sendNotification();

}
