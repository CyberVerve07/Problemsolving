package dailycode.july9.ecommerce;

public class main {
    public static void main(String[] args) {
        // Electronics product (Base price: 50000)
        Product laptop = new ElectronicsProducts("Laptop", 50000);

        // Clothing product (Base price: 2000)
        Product tShirt = new ClothingProduct("T-Shirt", 2000);

        System.out.println("Laptop Price after Discount: " + laptop.discount());
        // Output: 45000.0 (10% discount applied)

        System.out.println("T-Shirt Price after Discount: " + tShirt.discount());
        // Output: 1600.0 (20% discount applied)
    }
}

