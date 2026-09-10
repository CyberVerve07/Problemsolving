package Java8.StreamApi;

import java.util.Arrays;
import java.util.List;

class Product {

    String productName;
    double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
}

public class Demo13 {

    static void main() {

        // Given a list of products, use filter() to find products
        // with price greater than 1,000
        // and map() to apply a 10% discount.

        List<Product> products = Arrays.asList(
                new Product("I Phone", 850000),
                new Product("Washing Machine", 30000),
                new Product("AC", 50000),
                new Product("MacBook", 1500000)
        );

        products.stream()
                .filter(p -> p.productPrice > 1000)
                .map(p -> p.productPrice - (p.productPrice * 10 / 100));

    }
}