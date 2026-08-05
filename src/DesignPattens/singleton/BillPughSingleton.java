package DesignPattens.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * 5. Bill Pugh Singleton (Static Inner Class Pattern)
 * ----------------------------------------------------
 * - Recommended lazy initialization approach before Java 5 / Enums.
 * - When BillPughSingleton is loaded into memory, inner class is NOT loaded.
 * - SingletonHelper is loaded into memory ONLY when getInstance() is invoked.
 * - JVM guarantees classloading thread-safety automatically!
 */
public class BillPughSingleton implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = 1L;

    private BillPughSingleton() {
        // Reflection defense
        if (SingletonHelper.INSTANCE != null) {
            throw new RuntimeException("Reflection Attack Blocked: Instance already exists!");
        }
    }

    // Static inner helper class
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Serialization defense
    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    // Cloning defense
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton instance is not allowed!");
    }

    public void doSomething() {
        System.out.println("BillPughSingleton is performing work.");
    }
}
