package MultiThreading;

public class Demosleep {
    public static void main(String[] args) {

        // Even numbers ke liye thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i = i + 2) {
                    System.out.println("Print even numbers: " + i + " -> " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }, "Even-Thread");

        // Odd numbers ke liye thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 1; j <= 10; j = j + 2) {
                    System.out.println("Printing the odd numbers: " + j + " -> " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }, "Odd-Thread");

        try {
            // Pehle t1 start hoga aur poora execute hoga
            t1.start();
            t1.join(); // Main thread yahan wait karega jab tak t1 dead nahi hota

            // t1 ke khatam hone ke baad t2 start hoga
            t2.start();
            t2.join(); // Main thread t2 ke khatam hone ka wait karega

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Execution finished.");
    }
}