package dailycode.july20.Ecom;

public abstract class OrderManagement {

        private  String orderId;
        private  int  otp;
         private  String type;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OrderManagement(String orderId, int otp, String type) {
        this.orderId = orderId;
        this.otp = otp;
        this.type = type;
    }

      abstract  void  placeOrder();
     abstract  void  editOrder();
     abstract  void  conformOrder();



       final   void  getOrderStatus(){
             System.out.println("Order  id is :"+getOrderId());
             System.out.println("OTP is "+getOtp());
             System.out.println("Order type is "+getType());
         }


}
