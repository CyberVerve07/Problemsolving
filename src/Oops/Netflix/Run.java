package Netflix;

public class Run {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        NETFLIX SYSTEM DEMO & SIMULATION         ");
        System.out.println("=================================================");

        // 1. User Registration
        System.out.println("\n[Step 1] Registering User...");
        UserRegistration user = new UserRegistration(
            2456, 
            "Aditya", 
            "aditya@gmail.com", 
            "securePass123", 
            "Basic"
        );
        user.displayUserDetails();

        // 2. Login Simulation
        System.out.println("\n[Step 2] User Login Simulation...");
        // Test failed login
        user.login("aditya@gmail.com", "wrongPass");
        // Test successful login
        boolean loginSuccess = user.login("aditya@gmail.com", "securePass123");

        if (loginSuccess) {
            // 3. Setup Initial Subscription Plan
            System.out.println("\n[Step 3] Initializing Preferred Subscription (Basic)...");
            user.currentSubscription = new BasicSubscription("Basic", 399, "Mobile", "720p");
            user.displayUserDetails();
            user.currentSubscription.showDetails();

            // 4. Upgrade Plan Simulation
            System.out.println("\n[Step 4] Upgrading Plan...");
            UpgradePlan planner = new UpgradePlan();
            System.out.println("Choosing Option 3: Premium Plan");
            Subscription newPlan = planner.upgrade(3);
            
            if (newPlan != null) {
                user.currentSubscription = newPlan;
                user.subscriptionType = newPlan.planName;
                System.out.println("\n--- Plan Upgraded Successfully! ---");
                user.displayUserDetails();
                user.currentSubscription.showDetails();
            }

            // 5. Movie Watching Simulation
            System.out.println("\n[Step 5] Movie Catalog & Watching Simulation...");
            Movie movie = new Movie("M101", "Inception", "Sci-Fi/Action", "2h 28m", "8.8/10");
            movie.displayMovie();
            
            System.out.println("\nStarting Watch Session...");
            // Instantiate static nested class Watching
            Movie.Watching watchSession = new Movie.Watching(
                movie.movieId,
                movie.title,
                movie.name, // genre
                movie.duration,
                movie.rating
            );
        }

        System.out.println("\n=================================================");
        System.out.println("             DEMO COMPLETED SUCCESSFULLY         ");
        System.out.println("=================================================");
    }
}
