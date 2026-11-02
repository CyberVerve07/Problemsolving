package DependencyInjection;

import DependencyInjection.NotificationService.EmailNotification;
import DependencyInjection.NotificationService.MessageNotification;
import DependencyInjection.NotificationService.Notification;

public class Main {
    public static void main(String[] args) {

        Notification notification=new MessageNotification();


        OrderService orderService=new OrderService(notification);
        orderService.placeOrder();
    }
}


//So now  one more problem with the main method if we have more services it also become the
//tightly couple sso for solving that