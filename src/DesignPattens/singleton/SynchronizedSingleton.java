package DesignPattens.singleton;

/**
 * 3. Thread-Safe Synchronized Method Singleton
 * ----------------------------------------------
 * - Instance is lazily initialized and thread-safe using `synchronized`.
 * - Pros: Simple lazy loading and thread safety.
 * - Cons: Severe performance bottleneck! Synchronization is only needed for the FIRST call,
 *         but every subsequent call acquires and releases lock unnecessarily.
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {}

    // Method-level synchronized keyword guarantees single-thread entry at a time
    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("SynchronizedSingleton is performing work.");
    }
}
