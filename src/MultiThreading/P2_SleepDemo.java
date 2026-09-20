package MultiThreading;

/**
 * Question 2: sleep() Method Demo
 * --------------------------------
 * sleep() method current executing thread ko specified time ke liye pause (TIMED_WAITING) karta hai.
 * Key Points:
 * 1. Thread.sleep() static method hai.
 * 2. Ye locks ko RELEASE NAHI karta.
 * 3. Ye InterruptedException throw kar sakta hai agar dusra thread ise interrupt kare.
 */
public class P2_SleepDemo {

    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " started working...");
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Processing step " + i + "/5");
                    // Thread ko 1 second (1000ms) ke liye pause karte hain
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + " completed successfully!");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted during sleep!");
            }
        }, "WorkerThread");

        worker.start();

        // Main thread worker ka state monitor kar sakta hai
        try {
            Thread.sleep(1500); // 1.5 seconds wait
            System.out.println("Worker thread state during sleep: " + worker.getState()); // TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
