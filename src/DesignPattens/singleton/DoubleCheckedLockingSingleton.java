package DesignPattens.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * 4. Double-Checked Locking (DCL) Singleton
 * -------------------------------------------
 * - Industry standard approach for lazy thread-safe initialization.
 * - Why volatile? Prevents Instruction Reordering (Memory Barrier).
 *   Without volatile, CPU/JVM can reorder:
 *     1. Allocate memory -> 2. Point reference to memory -> 3. Call constructor
 *   Thread B could see instance != null before Step 3 completes (half-initialized object).
 *
 * - Includes protections against:
 *   1. Reflection (checks null in constructor)
 *   2. Serialization (implements readResolve)
 *   3. Cloning (overrides clone to throw exception or return instance)
 */
public class DoubleCheckedLockingSingleton implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = 1L;

    // volatile keyword is mandatory here!
    private static volatile DoubleCheckedLockingSingleton instance;

    // Private constructor with Reflection Defense
    private DoubleCheckedLockingSingleton() {
        if (instance != null) {
            throw new RuntimeException("Reflection Attack Blocked: Instance already exists! Use getInstance().");
        }
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        // First check (no synchronization lock overhead for already created instances)
        if (instance == null) {
            // Synchronize on class object
            synchronized (DoubleCheckedLockingSingleton.class) {
                // Second check (ensures only one thread creates instance after acquiring lock)
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    // Serialization Defense: Called during deserialization to preserve Singleton contract
    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    // Cloning Defense: Prevent cloning of Singleton instance
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Option 1: Throw Exception
        throw new CloneNotSupportedException("Cloning of Singleton instance is not allowed!");
        // Option 2: Return existing instance: return getInstance();
    }

    public void doSomething() {
        System.out.println("DoubleCheckedLockingSingleton is performing work.");
    }
}
