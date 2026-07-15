package dailycode.july15;

public class Delivary {

    public void estimateDelivery(String src, String des) {
        System.out.println("Delivery is  in processing wait ");
    }

    class ExpressTime extends Delivary{
         public  void  estimateDelivery(String src,String des){
             System.out.println("Estimate deliver time is ::::: Your Order is By Express ");
         }




    }}

    class  OneDayDelivery extends Delivary{
        public  void  estimateDelivery(String src,String des){
            System.out.println("YOur order is on processing estimate time is 24 hours:");
        }
           }




//Debugging mannuly the control