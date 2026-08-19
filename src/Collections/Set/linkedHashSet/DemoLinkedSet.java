package Collections.Set;

import java.util.LinkedHashSet;

public class DemoLinkedSet {
    public static void main(String[] args) {
        LinkedHashSet<String> products = new LinkedHashSet<>();
        products.add("iPhone");
        products.add("SamsungS23");
        products.add("RealMe7");
        products.add("One plus");
        products.add("Moto");
        products.add("Nothing");
        //
        System.out.println(products);
        // Print: [iPhone, SamsungS23, RealMe7, One plus]
    }
}




