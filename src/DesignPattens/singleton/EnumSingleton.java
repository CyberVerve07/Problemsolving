package DesignPattens.singleton;

/**
 * 6. Enum Singleton (Effective Java Recommendation)
 * --------------------------------------------------
 * - As per Joshua Bloch, Enum Singleton is the BEST way to implement Singleton in Java.
 * - Advantages:
 *   1. Extremely concise code.
 *   2. Guaranteed single instance by JVM spec.
 *   3. Built-in thread safety.
 *   4. Built-in defense against Serialization (JVM handles Enum serialization safely).
 *   5. Built-in defense against Reflection (Constructor.newInstance() explicitly throws IllegalArgumentException for Enums).
 *   6. Enums cannot be cloned (clone() method in Enum is final and throws CloneNotSupportedException).
 */
public enum EnumSingleton {

    INSTANCE;

    // Field example inside enum singleton
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void doSomething() {
        System.out.println("EnumSingleton is performing work with value: " + value);
    }
}
