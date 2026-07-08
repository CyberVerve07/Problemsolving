package dailycode.july8;

public class Car {

    // Private Variables
    private String brand;
    private int speed;

    // Brand Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Speed Getter (No Setter for direct access to speed)
    public int getSpeed() {
        return speed;
    }

    // Accelerate Method (increases speed, max speed 220)
    public void accelerate(int increment) {
        if (increment > 0) {
            this.speed += increment;
            if (this.speed > 220) {
                this.speed = 220;
                System.out.println("Maximum speed limit (220) reached!");
            }
            System.out.println("Car accelerated. Current speed: " + this.speed);
        } else {
            System.out.println("Invalid acceleration amount!");
        }
    }

    // Brake Method (decreases speed, min speed 0)
    public void brake(int decrement) {
        if (decrement > 0) {
            this.speed -= decrement;
            if (this.speed < 0) {
                this.speed = 0;
                System.out.println("Car has stopped.");
            }
            System.out.println("Brake applied. Current speed: " + this.speed);
        } else {
            System.out.println("Invalid brake amount!");
        }
    }
}
