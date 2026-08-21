package Collections.Set.TreeSet.Task;

import Collections.Set.TreeSet.Order;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        TreeSet<Product> odr = new TreeSet<>();

        Product product1 = new Product("123", "Clothes", "Dispatch", 800);
        Product product2 = new Product("557", "iPhone16", "Shipped", 80000);
        Product product3 = new Product("908", "AC", "Delivered", 30000);
        Product product4 = new Product("123", "WashingMachine", "Delivered", 800);
        Product product5 = new Product("987", "T-shirt", "Shipped", 700);
        Product product6 = new Product("345", "Laptop", "Shipped", 800);

        odr.add(product1);
        odr.add(product2);
        odr.add(product3);
        odr.add(product4);
        odr.add(product5);
        odr.add(product6);

        //use for loop for iterate
        for (Product product : odr) {
            System.out.println(product.productId + " " + product.productName + " " + product.status + " " + product.price);
        }


    }

}


//Star patten ->