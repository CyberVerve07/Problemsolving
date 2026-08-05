package august.augest5;

public class Product {
    //Question 5: Online Shopping Cart
    //addToCart(String productName, int quantity)
    //Rules
    //Product null
    //Product blank
    //Quantity <=0
    //Quantity >10
    public static void main(String[] args) {

        try {
            cart("I phone 16 pro",0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void cart(String product, int qty) throws IllegalArgumentException {

        if (product == null) {
            throw new IllegalArgumentException("Product name can't be null");
        }
        if (product.isBlank())
        {
            throw new IllegalArgumentException("\"Product name cannot be blank.\"");
        }

      if (qty<=0){
    throw new IllegalArgumentException("Product quantity cant be negative ");
}

            if (qty > 10) {
                throw new IllegalArgumentException("Product Quantity must be 10 ");
            }
        System.out.println("Product name is "+product);
        System.out.println("Product Quantity is "+qty);
        }
    }
