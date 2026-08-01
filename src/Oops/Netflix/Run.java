package oops.netflix;

/**
 * Run — Main entry point for Netflix System Demo.
 *
 * This class demonstrates multiple OOP concepts in a real-world scenario:
 * 1. ENCAPSULATION — private fields with getters/setters in UserRegistration
 * 2. INHERITANCE — BasicSubscription extends Subscription
 * 3. COMPOSITION — UserRegistration HAS-A Subscription
 * 4. POLYMORPHISM — Subscription reference holding BasicSubscription/PremiumSubscription
 * 5. STATIC NESTED CLASS — Movie.Watching
 *
 * @author Aditya
 * @version 2.0
 */
public class Run {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        NETFLIX SYSTEM DEMO & SIMULATION         ");
        System.out.println("=================================================");

        // 1. User Registration — demonstrates Encapsulation (validation in setters)
        System.out.println("\n[Step 1] Registering User...");
        UserRegistration user = new UserRegistration(
                2456,
                "Aditya",
                "aditya@gmail.com",
                "securePass123",
                "Basic"
        );
        user.displayUserDetails();

        // 2. Login Simulation — demonstrates method logic with string comparison
        System.out.println("\n[Step 2] User Login Simulation...");
        user.login("aditya@gmail.com", "wrongPass");       // Test failed login
        boolean loginSuccess = user.login("aditya@gmail.com", "securePass123"); // Test success

        if (loginSuccess) {
            // 3. Setup Initial Subscription — demonstrates Composition (HAS-A)
            System.out.println("\n[Step 3] Initializing Preferred Subscription (Basic)...");
            user.setCurrentSubscription(new BasicSubscription("Basic", 399, "Mobile", "720p"));
            user.displayUserDetails();
            user.getCurrentSubscription().showDetails();

            // 4. Upgrade Plan — demonstrates Polymorphism (Factory-like pattern)
            System.out.println("\n[Step 4] Upgrading Plan...");
            UpgradePlan planner = new UpgradePlan();
            System.out.println("Choosing Option 3: Premium Plan");
            Subscription newPlan = planner.upgrade(3);

            if (newPlan != null) {
                user.setCurrentSubscription(newPlan);
                user.setSubscriptionType(newPlan.getPlanName());
                System.out.println("\n--- Plan Upgraded Successfully! ---");
                user.displayUserDetails();
                user.getCurrentSubscription().showDetails();
            }

            // 5. Movie Watching — demonstrates Static Nested Class
            System.out.println("\n[Step 5] Movie Catalog & Watching Simulation...");
            Movie movie = new Movie("M101", "Inception", "Sci-Fi/Action", "2h 28m", "8.8/10");
            movie.displayMovie();

            System.out.println("\nStarting Watch Session...");
            // Instantiate static nested class — no Movie instance required
            Movie.Watching watchSession = new Movie.Watching(
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getGenre(),
                    movie.getDuration(),
                    movie.getRating()
            );
        }

        System.out.println("\n=================================================");
        System.out.println("             DEMO COMPLETED SUCCESSFULLY         ");
        System.out.println("=================================================");
    }
}
