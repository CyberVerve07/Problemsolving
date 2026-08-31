package Java8.StreamsInterview;

import java.util.*;
import java.util.stream.Collectors;

class OrderItem {
    private String productName;
    private String category;
    private double price;
    private int quantity;

    public OrderItem(String productName, String category, double price, int quantity) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getTotalPrice() { return price * quantity; }
}

class Order {
    private String orderId;
    private String status; // "DELIVERED", "CANCELLED", "PENDING"
    private List<OrderItem> items;

    public Order(String orderId, String status, List<OrderItem> items) {
        this.orderId = orderId;
        this.status = status;
        this.items = items;
    }

    public String getStatus() { return status; }
    public List<OrderItem> getItems() { return items; }
}

class CategorySummary {
    private double totalRevenue;
    private String topProduct;

    public CategorySummary(double totalRevenue, String topProduct) {
        this.totalRevenue = totalRevenue;
        this.topProduct = topProduct;
    }

    public double getTotalRevenue() { return totalRevenue; }
    public String getTopProduct() { return topProduct; }
}

public class P5_ComplexOrderAggregation {
    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order("O1", "DELIVERED", List.of(
                new OrderItem("Laptop", "Electronics", 1200, 1),
                new OrderItem("Mouse", "Electronics", 25, 2)
            )),
            new Order("O2", "CANCELLED", List.of(
                new OrderItem("TV", "Electronics", 800, 1)
            )),
            new Order("O3", "DELIVERED", List.of(
                new OrderItem("Desk", "Furniture", 300, 2),
                new OrderItem("Chair", "Furniture", 150, 4),
                new OrderItem("Keyboard", "Electronics", 100, 1)
            ))
        );

        Map<String, CategorySummary> summaryByCategory = orders.stream()
            // 1. Filter out non-delivered orders
            .filter(order -> "DELIVERED".equals(order.getStatus()))
            // 2. Flatten items inside delivered orders
            .flatMap(order -> order.getItems().stream())
            // 3. Group by category and compute BOTH revenue & top product using teeing
            .collect(Collectors.groupingBy(
                OrderItem::getCategory,
                Collectors.teeing(
                    // Collector 1: Total Revenue
                    Collectors.summingDouble(OrderItem::getTotalPrice),
                    // Collector 2: Top Item by unit price
                    Collectors.maxBy(Comparator.comparingDouble(OrderItem::getPrice)),
                    // Merger Function: combine revenue and top product into summary object
                    (totalRev, topItem) -> new CategorySummary(
                        totalRev, 
                        topItem.map(OrderItem::getProductName).orElse("N/A")
                    )
                )
            ));

        System.out.println("=== Order Summary by Category ===");
        summaryByCategory.forEach((category, summary) -> {
            System.out.println("Category: " + category);
            System.out.println("  Total Revenue: $" + summary.getTotalRevenue());
            System.out.println("  Top Unit Price Item: " + summary.getTopProduct());
        });
    }
}
