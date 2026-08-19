package dailycode.july.day25.onlinebankingsystem.interfaces;

public class Main {
    public static void main(String[] args) {
        Product product = message -> System.out.println(message);
        product.publish("Hello from Lambda Expression!");
    }
}
