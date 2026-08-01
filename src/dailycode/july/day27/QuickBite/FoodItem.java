package dailycode.july.day27.QuickBite;

public class FoodItem {

    private String foodID;
    private String description;
    private Boolean categoryIsAvailable;
    private String foodName;
    private double price;

    public FoodItem(String foodID, String description, Boolean categoryIsAvailable, String foodName, double price) {
        this.foodID = foodID;
        this.description = description;
        this.categoryIsAvailable = categoryIsAvailable;
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isCategoryAvailable() {
        return categoryIsAvailable;
    }

    public Boolean getCategoryIsAvailable() {
        return categoryIsAvailable;
    }

    public void setCategoryIsAvailable(Boolean categoryIsAvailable) {
        this.categoryIsAvailable = categoryIsAvailable;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayFood() {
        System.out.println("Food Item Details:");
        System.out.println("Food ID: " + getFoodID());
        System.out.println("Food Name: " + getFoodName());
        System.out.println("Food Price: " + getPrice());
        System.out.println("Description: " + getDescription());
        System.out.println("Available: " + isCategoryAvailable());
        System.out.println();
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
        System.out.println("Updated Price for " + foodName + ": " + this.price);
    }

    public void changeAvailability(boolean available) {
        this.categoryIsAvailable = available;
        if (this.categoryIsAvailable) {
            System.out.println("Food Item is now AVAILABLE.");
        } else {
            System.out.println("Food Item is now OUT OF STOCK.");
        }
    }
}

