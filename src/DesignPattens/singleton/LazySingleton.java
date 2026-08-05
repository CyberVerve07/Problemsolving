package DesignPattens.singleton;

/**
 * 2. Lazy Initialization Singleton (Non Thread-Safe)
 * ----------------------------------------------------
 * - Instance is created only when requested for the first time.
 * - Pros: Efficient memory usage (lazy loading).
 * - Cons: NOT thread-safe! Multiple threads entering getInstance() simultaneously
 *         can create multiple instances.
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            // Race condition can happen here in multi-threaded environment!
            instance = new LazySingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("LazySingleton is performing work.");
    }
}
