package DependencyInjection.NotificationService;

public class MessageNotification implements Notification{

    @Override
    public void NotificationSend() {
        System.out.println("Notification is received by the Messages:");
    }
}

//Iam learn the Dependency injection in java spring means  how to make the Services more independent and lossely couped
//means low dependency and more effective way to  efficient

//SOLID Design
//S stand for the Single responsibility principle one class only one responsibility
//O-> My class is open for extension and closed for modification
//L->Liscve substitution
//I->Interface Separation use  interfaces is the best design o write the code for effective manner
//D->Make sure my code is not dependent to another module


