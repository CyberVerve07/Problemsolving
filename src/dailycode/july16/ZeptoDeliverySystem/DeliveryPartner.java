package dailycode.july16.ZeptoDeliverySystem;

import java.util.Objects;

public class DeliveryPartner {
    private  String partnerName;
    private  int orderId;


    public DeliveryPartner(String partnerName, int orderId) {
        this.partnerName = partnerName;
        this.orderId = orderId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
         if (Objects.equals(partnerName, " Aditya"))
        this.partnerName = partnerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
         if(orderId== 5054) {
             this.orderId = orderId;
         }else {
             System.out.println(" Order is is not match : ");
         }
    }



         void  deliveryOrder(){
             System.out.println(" Order is delivered please tracking the process  in your app ");
         }

}
