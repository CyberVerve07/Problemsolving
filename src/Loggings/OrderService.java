package Loggings;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ===================================================================================
 *                         REAL-WORLD BACKEND SERVICE EXAMPLE
 * ===================================================================================
 * 
 * 💡 CONCEPT: How to write Production-Ready Backend Code with Logging & Observability.
 * 
 * Key Components Included:
 * 1. Log Levels (INFO, WARNING, SEVERE / ERROR, FINE / DEBUG)
 * 2. Structured Log context using Correlation ID / Trace ID
 * 3. Metrics Tracking (Simulating Counters & Timers for Prometheus / Micrometer)
 * 4. Error Handling & Log formatting best practices
 * 
 * ===================================================================================
 */
public class OrderService {

    // Logger instance - Standard SLF4J / Logback / java.util.logging logger in backend
    private static final Logger log = Logger.getLogger(OrderService.class.getName());

    // --- Simulated Metrics (In production, use Micrometer / Prometheus counters/timers) ---
    private static long totalOrdersPlaced = 0;
    private static long totalOrderFailures = 0;

    // DTO / Request Class
    public static class OrderRequest {
        private String orderId;
        private String userId;
        private String productId;
        private double amount;

        public OrderRequest(String userId, String productId, double amount) {
            this.orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8);
            this.userId = userId;
            this.productId = productId;
            this.amount = amount;
        }

        public String getOrderId() { return orderId; }
        public String getUserId() { return userId; }
        public String getProductId() { return productId; }
        public double getAmount() { return amount; }
    }

    /**
     * Handles order processing with end-to-end logging and metric tracking.
     * 
     * @param request  Incoming order details
     * @param traceId  Distributed Trace ID passed from API Gateway / HTTP Header
     */
    public void processOrder(OrderRequest request, String traceId) {
        long startTimeMs = System.currentTimeMillis();

        // 1. Log Request Entry with Trace Context (Contextual Logging)
        log.info(formatLog(traceId, "Step 1: Received order request for orderId: " + request.getOrderId() 
                + ", userId: " + request.getUserId() + ", amount: $" + request.getAmount()));

        try {
            // 2. Inventory Check (DEBUG level log for internal step details)
            log.log(Level.FINE, () -> formatLog(traceId, "Step 2: Checking inventory stock for productId: " + request.getProductId()));
            checkInventory(request.getProductId(), traceId);

            // 3. Payment Processing
            log.info(formatLog(traceId, "Step 3: Initiating payment gateway call for amount: $" + request.getAmount()));
            boolean paymentSuccess = simulatePaymentGatewayCall(request.getAmount(), traceId);

            if (!paymentSuccess) {
                // WARNING level: Expected business failure (e.g., insufficient funds)
                log.warning(formatLog(traceId, "Step 3 WARN: Payment declined for orderId: " + request.getOrderId()));
                totalOrderFailures++;
                return;
            }

            // 4. Order Success
            totalOrdersPlaced++;
            long executionTimeMs = System.currentTimeMillis() - startTimeMs;

            // Log success + record latency metric
            log.info(formatLog(traceId, "Step 4 SUCCESS: Order " + request.getOrderId() 
                    + " completed successfully in " + executionTimeMs + "ms"));

        } catch (Exception e) {
            // 5. System Error (SEVERE / ERROR level log with Stack Trace)
            totalOrderFailures++;
            log.log(Level.SEVERE, formatLog(traceId, "CRITICAL ERROR: Failed to process order " 
                    + request.getOrderId() + " due to unexpected error: " + e.getMessage()), e);
        }
    }

    private void checkInventory(String productId, String traceId) {
        // Simulating inventory logic
        log.info(formatLog(traceId, "Inventory reserved for product: " + productId));
    }

    private boolean simulatePaymentGatewayCall(double amount, String traceId) throws Exception {
        // Simulate potential gateway latency or failure
        int randomVal = ThreadLocalRandom.current().nextInt(1, 10);

        if (randomVal == 9) {
            // Unexpected infrastructure exception
            throw new RuntimeException("Payment Gateway Timeout (504 Gateway Timeout)");
        } else if (randomVal > 6) {
            // Business logic failure (e.g. Card declined)
            return false;
        }

        return true;
    }

    /**
     * Helper method to attach Trace ID to every log line (Simulates MDC / Logback Pattern Layout)
     */
    private String formatLog(String traceId, String message) {
        return "[TraceID: " + traceId + "] " + message;
    }

    // --- Main Method to test execution ---
    public static void main(String[] args) {
        OrderService service = new OrderService();

        System.out.println("=== SIMULATING BACKEND ORDER PROCESSING WITH LOGGING & METRICS ===\n");

        for (int i = 1; i <= 3; i++) {
            // Generate a unique Trace ID for each incoming HTTP request (Simulates API Gateway)
            String traceId = "TRACE-" + UUID.randomUUID().toString().substring(0, 8);
            OrderRequest req = new OrderRequest("USER-" + (100 + i), "PROD-99", 150.0 + (i * 20));

            System.out.println("\n--- Processing Request #" + i + " ---");
            service.processOrder(req, traceId);
        }

        // Print aggregated metrics report (Monitoring output example)
        System.out.println("\n=========================================================");
        System.out.println("            AGGREGATED SERVICE METRICS (MONITORING)       ");
        System.out.println("=========================================================");
        System.out.println("Total Orders Successfully Placed: " + totalOrdersPlaced);
        System.out.println("Total Order Processing Failures : " + totalOrderFailures);
        System.out.println("=========================================================");
    }
}