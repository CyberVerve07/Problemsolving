package dailycode.july.day27.QuickBite;

public class Cart {

    private String cartId;
    private String customer;
    private String foodItems;
    private double totalAmount;

    public Cart(String cartId, String customer, String foodItems, double totalAmount) {
        this.cartId = cartId;
        this.customer = customer;
        this.foodItems = foodItems;
        this.totalAmount = totalAmount;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(String foodItems) {
        this.foodItems = foodItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void displayCart() {
        System.out.println(":::::::::::::::::::::::::::::::");
        System.out.println("Your Items are:");
        System.out.println("Cart ID: " + getCartId());
        System.out.println("Customer Name: " + getCustomer());
        System.out.println("Food Item(s): " + getFoodItems());
        System.out.println("Total Amount: " + getTotalAmount());
        System.out.println("::::::::::::::::::::::::::::::::::::");
        System.out.println();
    }

    public void calculateTotal(double gstPercentage) {
        System.out.println("Calculating Total Bill (GST: " + gstPercentage + "%)...");
        double gstAmount = (totalAmount * gstPercentage) / 100;
        this.totalAmount += gstAmount;
        System.out.println("Total amount to pay (including GST): " + this.totalAmount);
    }
}

