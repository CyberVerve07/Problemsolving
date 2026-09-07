package Loggings;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ===================================================================================
 *                    LOGGING BEST PRACTICES VS BAD PRACTICES
 * ===================================================================================
 * 
 *  WHY IS System.out.println() BAD IN BACKEND PRODUCTION?
 * 1. Synchronous I/O: System.out blocks the main thread, severely degrading API performance under high load.
 * 2. No Log Levels: You cannot disable debug prints in Production without modifying code.
 * 3. No Timestamp / Thread Info: Does not show thread name, class, line number, or exact timestamp.
 * 4. Cannot stream to centralized log collectors (ELK, Splunk, Datadog) easily.
 * 
 * ===================================================================================
 */
public class LoggingBestPracticesDemo {

    private static final Logger logger = Logger.getLogger(LoggingBestPracticesDemo.class.getName());

    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("        LOGGING BEST PRACTICES DEMO IN BACKEND           ");
        System.out.println("=========================================================\n");

        demonstrateLogLevels();
        demonstrateBadVsGoodLogging();
        demonstratePiiMasking();
    }

    /**
     * 1. EXPLANATION OF LOG LEVELS (Hierarchy from low severity to high severity)
     */
    private static void demonstrateLogLevels() {
        System.out.println("--- 1. UNDERSTANDING LOG LEVELS ---");
        
        // TRACE / FINEST: Extremely granular step-by-step details (e.g. byte buffer contents, raw SQL queries)
        logger.log(Level.FINEST, "[TRACE/FINEST] Standard detail line by line.");

        // DEBUG / FINE: Developer diagnostic information during development/staging
        logger.log(Level.FINE, "[DEBUG/FINE] Entering method calculateDiscount() with user Tier = GOLD");

        // INFO: Key business milestones in application workflow (e.g. Service started, Order placed, Payment success)
        logger.info("[INFO] Application successfully started on port 8080");

        // WARN: Unexpected situation occurred, but application recovered or request continued (e.g. Cache miss, Rate limit threshold reached)
        logger.warning("[WARN] Redis cache connection timed out. Falling back to Database query.");

        // ERROR / SEVERE: Operation failed completely or exception caught (e.g. DB connection failed, Payment gateway down)
        logger.severe("[ERROR/SEVERE] Failed to save transaction record to database. Transaction rolled back.");

        System.out.println("✓ Log levels demonstrated above.\n");
    }

    /**
     * 2. BAD LOGGING VS GOOD LOGGING EXAMPLES
     */
    private static void demonstrateBadVsGoodLogging() {
        System.out.println("--- 2. BAD VS GOOD LOGGING PRACTICES ---");

        String userId = "USR-4092";
        double amount = 250.75;

        //  BAD PRACTICE 1: Using System.out.println
        // System.out.println("User " + userId + " paid " + amount);

        //  BAD PRACTICE 2: Swallowing Exception with e.printStackTrace()
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // BAD: e.printStackTrace(); // Prints to stderr without timestamp, logger routing, or trace context!
            // GOOD: Pass the exception object as the last parameter to logger to preserve full stack trace!
            logger.log(Level.SEVERE, "Failed arithmetic operation for userId: " + userId, e);
        }

        //  BAD PRACTICE 3: Expensive String Concatenation when log level is disabled
        // SLF4J / Log4j solution: Use parameterized placeholders like log.info("User {} paid {}", userId, amount)
        // Java Logger solution: Use Supplier lambda so string is formatted ONLY if level is enabled.
        logger.log(Level.INFO, () -> String.format("GOOD: User %s successfully processed payment of $%.2f", userId, amount));

        System.out.println();
    }

    /**
     * 3. SENSITIVE DATA (PII) MASKING
     * 
     *  CRITICAL BACKEND RULE: Never log Passwords, Credit Card numbers, CVV, SSN, or API Keys in plain text!
     * Doing so violates GDPR, PCI-DSS, and HIPAA compliance!
     */
    private static void demonstratePiiMasking() {
        System.out.println("--- 3. PII (PERSONALLY IDENTIFIABLE INFORMATION) MASKING ---");

        String creditCard = "4532-8910-1112-9988";
        String password = "SuperSecretPassword123!";

        //  BAD: Logging raw credit card or password
        // logger.info("Processing card: " + creditCard + " with pass: " + password);

        //  GOOD: Mask sensitive fields before logging
        String maskedCard = maskCreditCard(creditCard);
        logger.info("Processing transaction with card: " + maskedCard + " [Password masked]");

        System.out.println("✓ Masking demonstrated. Never leak secrets to log streams!");
    }

    private static String maskCreditCard(String card) {
        if (card == null || card.length() < 4) return "****";
        return "****-****-****-" + card.substring(card.length() - 4);
    }
}
