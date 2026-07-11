package Netflix;

public class UpgradePlan {
    public Subscription upgrade(int choice) {
        if (choice == 1) {
            return new BasicSubscription("Basic", 399, "Mobile", "720p");
        } else if (choice == 2) {
            return new StandardSubscription("Standard", 799, "Mobile/Tablet/Laptop", "1080p");
        } else if (choice == 3) {
            return new PremiumSubscription("Premium", 1499, "Mobile/Tablet/Laptop/TV", "4K HDR");
        } else {
            System.out.println("Invalid Choice! Please choose 1, 2, or 3.");
            return null;
        }
    }
}
