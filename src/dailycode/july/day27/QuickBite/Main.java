package dailycode.july.day27.QuickBite;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          WELCOME TO QUICKBITE APP               ");
        System.out.println("=================================================");

        // 1. Notification Service Instance
        NotificationService notificationService = new NotificationService();

        // 2. User Authentication
        System.out.println("\n--- MODULE 1: USER AUTHENTICATION ---");
        Authentication user = new Authentication(
                "CUST101",
                "Aditya Mahajan",
                "9876543210",
                "aditya@example.com",
                "123 Main Street, City",
                "password123",
                500.0 // Initial Wallet Balance = ₹500
        );

        user.viewProfile();
        user.login("password123");

        // Send Welcome Notification
        notificationService.sendSMSNotification(user.getPhoneNumber(), "Welcome to QuickBite App, Aditya!");

        // 3. Restaurant Service
        System.out.println("\n--- MODULE 2: RESTAURANT MANAGEMENT ---");
        Restaurant restaurant = new Restaurant(
                "REST201",
                "Delicious Bites",
                "Rajesh Kumar",
                "78 Food Street",
                "4.5 Stars",
                "30 mins",
                true
        );

        RestaurantService restaurantService = new RestaurantService();
        restaurantService.viewRestaurant(restaurant);

        // 4. Food Items
        System.out.println("\n--- MODULE 3: FOOD ITEMS ---");
        FoodItem pizza = new FoodItem("F101", "Cheesy Paneer Pizza", true, "Paneer Pizza", 299.0);
        FoodItem burger = new FoodItem("F102", "Crispy Veg Burger", true, "Veg Burger", 120.0);

        pizza.displayFood();
        burger.displayFood();

        // 5. Cart Management & Total Calculation
        System.out.println("\n--- MODULE 4: CART & BILLING ---");
        Cart cart = new Cart("CART301", user.getName(), pizza.getFoodName(), pizza.getPrice());
        cart.displayCart();

        // Calculate bill with 18% GST (299 + 18% GST = ₹352.82)
        cart.calculateTotal(18.0);
        double finalBillAmount = cart.getTotalAmount();

        // 6. Payment Service with Real Logic & Notifications
        System.out.println("\n--- MODULE 5: PAYMENT PROCESSING ---");

        // Scenario A: Paying via Wallet (Wallet Balance = ₹500, Required = ₹352.82) -> Success!
        System.out.println("\n--- Scenario A: Wallet Payment (Success) ---");
        Payment walletPayment = new WalletPay();
        boolean isPaid = walletPayment.processPayment(finalBillAmount, user, pizza.getFoodName());

        if (isPaid) {
            // Trigger Delivery Management
            System.out.println("\n--- MODULE 6: DELIVERY MANAGEMENT ---");
            DeliveryManagement delivery = new PremiumUser("DEL402", "Suresh (Express Rider)", user.getAddress(), "ORD902");
            delivery.assignDeliveryPartner();
            delivery.trackOrder();
            delivery.calculateDeliveryTime();
            delivery.deliverOrder();

            notificationService.sendOrderUpdate(user.getName(), "ORD902", "DELIVERED");
        }

        // Scenario B: Paying another order via Wallet (Remaining Balance = ₹147.18, Required = ₹300) -> Fails due to low balance!
        System.out.println("\n--- Scenario B: Wallet Payment (Insufficient Balance Check) ---");
        boolean secondPayment = walletPayment.processPayment(300.0, user, "Family Combo Meal");

        if (!secondPayment) {
            System.out.println("\n--- Falling back to UPI Payment ---");
            Payment upiPayment = new UpiPayment();
            upiPayment.processPayment(300.0, user, "Family Combo Meal");
        }

        // 7. Logout
        System.out.println("\n--- LOGOUT ---");
        user.logout();
        System.out.println("\n=================================================");
        System.out.println("          THANK YOU FOR USING QUICKBITE!        ");
        System.out.println("=================================================");
    }
}
