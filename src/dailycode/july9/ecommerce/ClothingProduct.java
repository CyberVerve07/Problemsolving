package dailycode.july9.ecommerce;

public class ClothingProduct extends Product {

    public ClothingProduct(String name, double price) {
        super(name, price);
    }

    // Method Overriding
    @Override
    public double discount() {
        // Clothing par 20% discount
        double discount = this.productPrice * 0.20;
        return this.productPrice - discount;
    }
}
