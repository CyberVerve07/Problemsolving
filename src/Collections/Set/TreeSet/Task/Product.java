package Collections.Set.TreeSet.Task;

public class Product implements Comparable<Product> {

    String productId;
    String productName;
    String status;
    double price;

    public Product(String productId, String productName,
                   String status, double price) {

        this.productId = productId;
        this.productName = productName;
        this.status = status;
        this.price = price;
    }


    @Override
    public int compareTo(Product o) {

        // Same productId -> duplicate
        if (this.productId.equals(o.productId)) {
            return 0;
        }

        // Different IDs -> sort by price
        int result = Double.compare(this.price, o.price);

        // Same price but different IDs
        if (result == 0) {
            return this.productId.compareTo(o.productId);
        }

        return result;
    }
}


/*
 * STAR APPROACH
 *
 * S -> Situation:
 * We need to store products where productId must be unique
 * and products should be sorted according to price.
 *
 * T -> Task:
 * We need to choose a data structure that can maintain
 * sorted products and prevent duplicate product IDs.
 *
 * A -> Action:
 * We use TreeSet because TreeSet maintains elements in sorted order.
 *
 * TreeSet uses compareTo() to decide whether two objects are equal.
 * Therefore:
 *
 * 1. If productId is same -> return 0
 *    This tells TreeSet that the product is duplicate.
 *
 * 2. If productId is different -> compare price
 *    This maintains products in ascending price order.
 *
 * 3. If price is also same -> compare productId
 *    This makes sure two different products with the same price
 *    are not treated as duplicates.
 *
 * R -> Result:
 * Duplicate product IDs are rejected and products with different
 * IDs are maintained in ascending order of price.
 */
