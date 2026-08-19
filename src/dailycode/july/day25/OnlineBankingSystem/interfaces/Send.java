package dailycode.july.day25.onlinebankingsystem.interfaces;

public class Send implements Product {
    @Override
    public void publish(String message) {
        System.out.println("Hello World: " + message);
    }
}
