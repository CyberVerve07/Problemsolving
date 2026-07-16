package dailycode.july16.BlinkitDelivery;

import java.util.Objects;

public class Order {
    private   String customerName;
     private  String productId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (Objects.equals(customerName, " Aditya")) {
            this.customerName = customerName;
        }
        else{
            System.out.println("Customer name is not Match :  ");
         }


    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
         if ( Objects.equals(productId,"98789")) {



             this.productId = productId;
         }
          else {
             System.out.println(" Product id is not Matched: ");
         }
    }

    public Order(String customerName, String productId) {
        this.customerName = customerName;
        this.productId = productId;
    }
      void  placeOrder(){
          System.out.println("==================");
          System.out.println(" You Order is shortly delivered :: Please check the Status in App ::");
          System.out.println("===================");
      }

}