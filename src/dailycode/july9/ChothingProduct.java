package dailycode.july9;

public class ChothingProduct extends Product {

    String fabric;
    String season;   // "Summer" or "Winter"

    // Default constructor
    ChothingProduct() {
        super();  // calls Product()
    }

    // Parameterized constructor
    public ChothingProduct(String productName, int productId, String productSize,
                           double price, String fabric, String season) {
        super(productName, productId, productSize, price);  // parent constructor
        this.fabric = fabric;
        this.season = season;
    }

    void view1() {
        super.view();   // call parent view first
        System.out.println("Fabric       : " + fabric);
        System.out.println("Season       : " + season);
        System.out.println("Category     : Clothing Product");
    }
}
