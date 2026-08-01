package dailycode.july.day09.ecommerce;

public class Product {
    String productName;
    double productPrice;



    Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;

    }

    public double discount() {

          return this.productPrice;



    }
}
