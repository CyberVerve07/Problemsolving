package dailycode.july9;

public class MensProduct extends Product {

    String mensShirts;
    String mensPants;
    String mensShoes;

    // Default constructor
    MensProduct() {
        super();  // calls Product()
    }
    // Parameterized constructor
    public MensProduct(String productName, int productId, String productSize,
                       double price, String mensShirts, String mensPants, String mensShoes) {
        super(productName, productId, productSize, price);  // parent constructor
        this.mensShirts = mensShirts;
        this.mensPants  = mensPants;
        this.mensShoes  = mensShoes;
    }

    void view2() {
        super.view();   // call parent view
        System.out.println("Men's Shirts : " + mensShirts);
        System.out.println("Men's Pants  : " + mensPants);
        System.out.println("Men's Shoes  : " + mensShoes);
        System.out.println("Category     : Men's Product");
    }
}
