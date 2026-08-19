package dailycode.july.day25.onlinebankingsystem.interfaces;

@FunctionalInterface
public interface Product {
    void publish(String message);

    default void print() {
        System.out.println("Default print method in Product interface.");
    }

    default void hi() {
        System.out.println("Hi from Product interface!");
    }

    static void println() {
        System.out.println("Static println method in Product interface.");
    }

    static void hello() {
        System.out.println("Hello from Product interface!");
    }

    static void helperMethod() {
        System.out.println("Private helper method — only accessible within this interface.");
    }
}
