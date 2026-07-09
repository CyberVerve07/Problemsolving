package dailycode.july9;

public class WomensProduct extends Product {

    String womenShirts;
    String womenShoes;
    String accessories;

    // Default constructor
    WomensProduct() {
        super();  // calls Product()
    }

    // Parameterized constructor
    public WomensProduct(String productName, int productId, String productSize,
                         double price, String womenShirts, String womenShoes, String accessories) {
        super(productName, productId, productSize, price);  // parent constructor
        this.womenShirts   = womenShirts;
        this.womenShoes    = womenShoes;
        this.accessories   = accessories;
    }
    void view3() {
        super.view();   // call parent view
        System.out.println("Women Shirts : " + womenShirts);
        System.out.println("Women Shoes  : " + womenShoes);
        System.out.println("Accessories  : " + accessories);
        System.out.println("Category     : Women's Product");
    }
}
