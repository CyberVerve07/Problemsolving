package dailycode.july16.BlinkitDelivery;

public class Main{
    public static void main(String[] args) {
        Process a=new Process();

           Order d1=new NormalOrder("Ronit","8393");
            Order d2=new ExpressDelivery("Raja","987897");
             Order d3=new ScheduleDelivery("Raja","987897");

               a.partner(d1);
               a.partner(d2);
               a.partner(d3);

    }
}
