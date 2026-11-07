package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

class LockFreeCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}