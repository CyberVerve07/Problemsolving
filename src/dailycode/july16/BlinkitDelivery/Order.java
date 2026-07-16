package dailycode.july16.BlinkitDelivery;

import java.util.Objects;

public class Order {
    private   String customerName;
     private  String productId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName != null && !customerName.trim().isEmpty()) {
            this.customerName = customerName;
        }
        else{
            System.out.println("Customer name is not valid!");
         }
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
         if (productId != null && !productId.trim().isEmpty()) {
             this.productId = productId;
         }
          else {
             System.out.println("Product ID is not valid!");
         }
    }

    public Order(String customerName, String productId) {
        setCustomerName(customerName);
        setProductId(productId);
    }
      void  placeOrder(){
          System.out.println("==================");
          System.out.println(" Your Order is shortly delivered :: Please check the Status in App ::");
          System.out.println("===================");
      }

}