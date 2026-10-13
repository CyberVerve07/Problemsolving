package MultiThreading;

import java.util.concurrent.Executors;

public class Demo25 {
    public static void main(String[] args)
            throws InterruptedException {

        Thread t = Thread.startVirtualThread(() -> {
            System.out.println("Hello from virtual thread!");
        });

        t.join();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 1000; i++) {
                executor.submit(() -> {
                    // Perform a blocking I/O task
                });
            }
        }

    }
}
