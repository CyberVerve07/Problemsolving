package MultiThreading;

// Shared-nothing/isolated approach using ThreadLocal or independent instances

public class IsolatedWorker implements Runnable {
    private int localCount = 0; // Owned exclusively by this thread

    @Override
    public void run() {
        localCount++; // No locks needed, zero contention
        System.out.println(Thread.currentThread().getName() + " local count: " + localCount);
    }
}
