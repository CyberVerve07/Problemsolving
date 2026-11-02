package DependencyInjection.NotificationService;

public class EmailNotification  implements Notification{


    @Override
    public void NotificationSend() {
        System.out.println("Notification is received by the Email");

    }
}
