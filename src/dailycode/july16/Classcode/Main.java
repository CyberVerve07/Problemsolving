package dailycode.july16.Classcode;

public class Main {
    public static void main(String[] args) {

       //  Notification send =new emailNotification();
         //Notification send1=new messageNotification();
         Notification send2=new pushNotification();
         Notification send3=  new whatsappNotification(); //Child class ka obj store hua ha parent class ma
          Process send4=new Process();

         // send.sendNotification();
          //send1.sendNotification();//Which method is call it decide at runtime
          //send2.sendNotification();
          //send3.sendNotification();
           send4.process(send3);  //Loss Coupling
           send4.process(send2);



//Actual decision happen on runtime which method is called
    }
}
//Based on the actual type it will be calling
  //One method is take care of everytime :