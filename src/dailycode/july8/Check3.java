package dailycode.july8;

public class Check3 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setBrand("Thar");
        
        System.out.println("Car Brand: " + myCar.getBrand());
        
        myCar.accelerate(100); // Speed: 100
        myCar.accelerate(150); // Speed: 250 -> Capped at 220
        
        myCar.brake(50);       // Speed: 170
        myCar.brake(200);      // Speed: -30 -> Capped at 0
    }
}
