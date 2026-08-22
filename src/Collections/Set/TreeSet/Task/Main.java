package Collections.Set.TreeSet.Task;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Product> products = new TreeSet<>();

        Product product1 = new Product("123", "Clothes", "Dispatch", 800);
        Product product2 = new Product("557", "IPhone16", "Shipped", 80000);
        Product product3 = new Product("908", "AC", "Delivered", 30000);
        Product product4 = new Product("123", "WashingMachine", "Delivered", 30000);
        Product product5 = new Product("987", "T-shirt", "Shipped", 700);

        addProduct(products, product1);
        addProduct(products, product2);
        addProduct(products, product3);
        addProduct(products, product4);
        addProduct(products, product5);

        for (Product product : products) {
            System.out.println(product);
        }
    }
    static void addProduct(TreeSet<Product> products, Product newProduct) {

        for (Product product : products) {

            if (product.productId.equals(newProduct.productId)) {
                return; // duplicate productId → don't add
            }
        }

        products.add(newProduct);
    }
}