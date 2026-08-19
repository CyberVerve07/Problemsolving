package Collections.Set.methods;

public record Demo(String userName, String orderId, int price) {
    // Java 21 ka record automatically equals aur hashCode bana deta hai.
    // Isme aur kuch likhne ki zaroorat nahi hai.
}