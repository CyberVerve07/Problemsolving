package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Question 1: Race Condition & Solution
 * --------------------------------------
 * Problem: Jab do ya do se zyada threads shared resource ko concurrently bina synchronization
 * ke modify karte hain, to final output timing/order par depend karta hai (Race Condition).
 * Solution:
 * 1. 'synchronized' keyword use karna (Locking mechanism)
 * 2. 'AtomicInteger' use karna (Lock-free atomic CAS operations)
 */
class SharedCounter {
    // 1. Unsafe counter - will cause Race Condition
    int unsafeCount = 0;
    public void incrementUnsafe() {
        unsafeCount++; // Read -> Modify -> Write (Not atomic)
    }

    // 2. Thread-safe using synchronized method
    int syncCount = 0;
    public synchronized void incrementSync() {
        syncCount++;
    }

    // 3. Thread-safe using AtomicInteger
    AtomicInteger atomicCount = new AtomicInteger(0);
    public void incrementAtomic() {
        atomicCount.incrementAndGet();
    }
}

public class P1_RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter counter = new SharedCounter();

        // Do threads create karenge jo har ek counter ko 10,000 baar increment karenge
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementUnsafe();
                counter.incrementSync();
                counter.incrementAtomic();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementUnsafe();
                counter.incrementSync();
                counter.incrementAtomic();
            }
        });

        t1.start();
        t2.start();

        // Main thread wait karega jab tak t1 aur t2 complete na ho jayein
        t1.join();
        t2.join();

        System.out.println("Expected count: 20000");
        System.out.println("1. Unsafe Count (Race Condition occurred): " + counter.unsafeCount);
        System.out.println("2. Synchronized Count (Fixed): " + counter.syncCount);
        System.out.println("3. AtomicInteger Count (Fixed): " + counter.atomicCount.get());
    }
}
