package MultiThreading;

class Counter2 {
    public int count = 0;

    // Fixed: Synchronized method to prevent race conditions
    public synchronized void increment() {
        count++;
    }
}

class Test7 {
    public static void main(String[] args) {
        // Fixed: Matching class and method names
        Counter c1 = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i > 100; i++) {
                c1.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i > 100; i++) {
                c1.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join(); // Fixed: Ensure both threads finish before printing
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final Count: " + c1.count);
    }
}