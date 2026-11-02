package DependencyInjection.NotificationService;

public class PopuNotification implements Notification{

    @Override
    public void NotificationSend() {
        System.out.println("Notification is received by the Popup");
    }
}
