package DesignPattens.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SINGLETON DESIGN PATTERN DEMONSTRATION & TESTS ");
        System.out.println("==================================================\n");

        testBasicUniqueness();
        testMultiThreading();
        testReflectionAttack();
        testSerializationAttack();
        testCloningAttack();
        testEnumSingleton();

        System.out.println("==================================================");
        System.out.println("   ALL SINGLETON TESTS COMPLETED SUCCESSFULLY!    ");
        System.out.println("==================================================");
    }

    private static void testBasicUniqueness() {
        System.out.println("--- 1. Testing Instance Uniqueness ---");
        DoubleCheckedLockingSingleton s1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton s2 = DoubleCheckedLockingSingleton.getInstance();

        System.out.println("Instance 1 HashCode: " + s1.hashCode());
        System.out.println("Instance 2 HashCode: " + s2.hashCode());
        System.out.println("Are both instances identical? " + (s1 == s2));
        System.out.println();
    }

    private static void testMultiThreading() {
        System.out.println("--- 2. Testing Multi-Threaded Safety ---");
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            executor.submit(() -> {
                DoubleCheckedLockingSingleton instance = DoubleCheckedLockingSingleton.getInstance();
                System.out.println("Thread-" + threadId + " obtained instance HashCode: " + instance.hashCode());
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }
        System.out.println();
    }

    private static void testReflectionAttack() {
        System.out.println("--- 3. Testing Reflection Attack Prevention ---");
        DoubleCheckedLockingSingleton instance1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton instance2 = null;

        try {
            Constructor<DoubleCheckedLockingSingleton> constructor = DoubleCheckedLockingSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (Exception e) {
            System.out.println("Reflection Attack Caught Successfully: " + e.getCause().getMessage());
        }

        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);
        System.out.println();
    }

    private static void testSerializationAttack() {
        System.out.println("--- 4. Testing Serialization/Deserialization Attack Prevention ---");
        DoubleCheckedLockingSingleton instance1 = DoubleCheckedLockingSingleton.getInstance();

        try {
            // Serialize instance1 to file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_test.ser"));
            oos.writeObject(instance1);
            oos.close();

            // Deserialize to instance2
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton_test.ser"));
            DoubleCheckedLockingSingleton instance2 = (DoubleCheckedLockingSingleton) ois.readObject();
            ois.close();

            // Clean up temporary file
            new File("singleton_test.ser").delete();

            System.out.println("Instance 1 HashCode: " + instance1.hashCode());
            System.out.println("Instance 2 HashCode: " + instance2.hashCode());
            System.out.println("Are both instances identical after serialization? " + (instance1 == instance2));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private static void testCloningAttack() {
        System.out.println("--- 5. Testing Cloning Attack Prevention ---");
        DoubleCheckedLockingSingleton instance1 = DoubleCheckedLockingSingleton.getInstance();

        try {
            // Invoking clone() method via reflection or direct call
            DoubleCheckedLockingSingleton instance2 = (DoubleCheckedLockingSingleton) instance1.clone();
            System.out.println("Cloned Instance HashCode: " + instance2.hashCode());
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning Attack Caught Successfully: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Cloning Failed with Exception: " + e.getMessage());
        }
        System.out.println();
    }

    private static void testEnumSingleton() {
        System.out.println("--- 6. Testing Enum Singleton ---");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;

        enum1.setValue(42);
        System.out.println("Enum1 HashCode: " + enum1.hashCode() + " | Value: " + enum1.getValue());
        System.out.println("Enum2 HashCode: " + enum2.hashCode() + " | Value: " + enum2.getValue());
        System.out.println("Are Enum instances identical? " + (enum1 == enum2));

        // Attempt reflection on Enum
        try {
            Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (Exception e) {
            System.out.println("Enum Reflection Protection: JVM prevented reflection -> " + e.getClass().getSimpleName());
        }
        System.out.println();
    }
}
