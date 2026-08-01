package dailycode.july.day27.QuickBite;

public class CartService {



        // Add Food
        public void addToCart(FoodItem food) {
            System.out.println(food.getFoodName() + " added to cart.");
        }

        // Remove Food
        public void removeFromCart(FoodItem food) {
            System.out.println(food.getFoodName() + " removed from cart.");
        }

        // View Cart
        public void viewCart(FoodItem food) {
            food.displayFood();
        }

        // Calculate Bill
        public void calculateBill(FoodItem food) {
            System.out.println("Total Bill : $" + food.getPrice());
        }

        // Clear Cart
        public void clearCart() {
            System.out.println("Cart Cleared Successfully.");
        }
    }


     //addToCart()
    //
    //removeFromCart()
    //
    //increaseQuantity()
    //
    //decreaseQuantity()
    //
    //clearCart()
    //
    //viewCart()
    //
    //calculateBill()

