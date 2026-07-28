package dailycode.july27.QuickBite;

public class RestaurantService {


        // Add Restaurant
        public void addRestaurant( Restudent restaurant) {
            System.out.println("Restaurant added successfully.");
        }

        // Remove Restaurant
        public void removeRestaurant(Restudent restaurant) {
            System.out.println("Restaurant removed successfully.");
        }

        // Search Restaurant
        public void searchRestaurant(Restudent restaurant) {
            System.out.println("Restaurant Found:");
            restaurant.viewRestudent();
        }

        // Open Restaurant
        public void openRestaurant(Restudent restaurant) {
            restaurant.setStatus(true);
            System.out.println(restaurant.getRestaurantName() + " is now OPEN.");

        }

        // Close Restaurant
        public void closeRestaurant(Restudent restaurant) {
            restaurant.setStatus(false);
            System.out.println(restaurant.getRestaurantName() + " is now CLOSED.");
        }

        // Update Restaurant
        public void updateRestaurant(Restudent restaurant) {
            System.out.println("Restaurant details updated successfully.");
        }

        // View Restaurant
        public void viewRestaurant(Restudent restaurant) {
            restaurant.viewRestudent();
        }
    }
