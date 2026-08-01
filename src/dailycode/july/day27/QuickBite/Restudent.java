package dailycode.july.day27.QuickBite;

public class Restudent {

    private String restaurantId;
    private String restaurantName;
    private String ownerName;
    private String address;
    private String rating;
    private String deliveryTime;
    private Boolean status;

    public Restudent(String restaurantId, String restaurantName, String ownerName, String address, String rating, String deliveryTime, Boolean status) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.ownerName = ownerName;
        this.address = address;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.status = status;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void openRestaurant() {
        this.status = true;
        System.out.println(getRestaurantName() + " is now OPEN.");
    }

    public void openRestaurant(Restudent restaurant) {
        if (restaurant != null) {
            restaurant.openRestaurant();
        }
    }

    public void closeRestaurant() {
        this.status = false;
        System.out.println(getRestaurantName() + " is now CLOSED.");
    }

    public void closeRestudent(Restudent restudent) {
        if (restudent != null) {
            restudent.closeRestaurant();
        }
    }

    public void viewRestudent() {
        viewRestaurant();
    }

    public void viewRestaurant() {
        System.out.println("Restaurant Details:");
        System.out.println("=====================");
        System.out.println("Restaurant ID: " + getRestaurantId());
        System.out.println("Restaurant Name: " + getRestaurantName());
        System.out.println("Owner Name: " + getOwnerName());
        System.out.println("Address: " + getAddress());
        System.out.println("Rating: " + getRating());
        System.out.println("Delivery Time: " + getDeliveryTime());
        System.out.println("Status: " + (Boolean.TRUE.equals(status) ? "OPEN" : "CLOSED"));
        System.out.println();
    }
}