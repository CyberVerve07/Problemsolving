package Collection.Collections;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product> {

    String productName;
    int productId;
    double productPrice;
    public Product(String productName, int productId, double productPrice) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        }
        @Override
        public int compareTo (Product p){
            int res = Integer.compare(this.productId, p.productId);

            return res;
        }


    }
