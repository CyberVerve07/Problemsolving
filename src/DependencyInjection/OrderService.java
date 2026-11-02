package DependencyInjection;

import DependencyInjection.NotificationService.EmailNotification;
import DependencyInjection.NotificationService.MessageNotification;
import DependencyInjection.NotificationService.Notification;

public class OrderService {

    //So instead of Creating the objet here iam using the Constructor::


    Notification notification;

    public OrderService(Notification notification) {
        this.notification = notification;
    }
    //Notification notification= new MessageNotification();
    //Notification notification1=new EmailNotification();
    //So in their approach the Single_Responsibility principle is failed it also handle the notification:
    //Failed the open and close principle :: when ever i want to add the new service i want to change the Notification type so here the problem::

    void placeOrder(){
        System.out.println("Order is placed:");
       notification.NotificationSend();

    }
}
