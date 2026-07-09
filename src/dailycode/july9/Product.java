package dailycode.july9;
public class Product  {

    String productName;
    int    productId;
    String productSize;
    double price;

    // Default constructor
    Product() {
    }

    // Parameterized constructor
    public Product(String productName, int productId, String productSize, double price) {
        this.productName = productName;
        this.productId   = productId;
        this.productSize = productSize;
        this.price       = price;
    }

    // Display basic product info
    void view() {
        System.out.println("-----------------------------");
        System.out.println("Product Name : " + productName);
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Size : " + productSize);
        System.out.println("Price        : Rs." + price);
    }


}
