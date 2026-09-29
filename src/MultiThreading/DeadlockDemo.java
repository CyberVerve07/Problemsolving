package MultiThreading;

public class DeadlockDemo {
    public static void main(String[] args) {
        final String resource1 = "Printer";
        final String resource2 = "Scanner";

        // Thread 1 tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked " + resource1);

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (resource2) {
                    System.out.println("Thread 1: Locked " + resource2);
                }
            }
        });

        // Thread 2 tries to lock resource2 then resource1 (Reverse Order)
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked " + resource2);

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (resource1) {
                    System.out.println("Thread 2: Locked " + resource1);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
