package DesignPattens.singleton;

/**
 * 1. Eager Initialization Singleton
 * ----------------------------------
 * - Instance is created at class loading time.
 * - Pros: Simple, Thread-safe (guaranteed by JVM class loader).
 * - Cons: Resource waste if instance is never used by the client.
 */
public class EagerSingleton {

    // Unique instance initialized eagerly
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // Private constructor prevents direct instantiation from outside
    private EagerSingleton() {
        // Prevent instantiation via reflection if INSTANCE already exists
        if (INSTANCE != null) {
            throw new RuntimeException("Instance already created! Use getInstance() method.");
        }
    }

    // Global access point
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("EagerSingleton is performing work.");
    }
}
