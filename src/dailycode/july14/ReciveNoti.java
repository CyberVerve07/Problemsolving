package dailycode.july14;

public class ReciveNoti {
    public static void main(String[] args) {

       //   EmailNoty emailNoty=new EmailNoty();
         // Sms sms=new Sms();
          //ushN pushN=new PushN();
           //emailNoty.send();
                  //sms.send();
           //pushN.send();



        Notification n1 = new EmailNoty();
        Notification n2 = new Sms();
        Notification n3 = new PushN();
        n1.send();
        n2.send();
        n3.send();
    }
}
