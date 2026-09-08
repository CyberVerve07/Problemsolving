package MultiThreading.Sprtember7;

public class Demo4 {
    public static void main(String[] args) {
        // Task for even numbers
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 100; i += 2) {
                System.out.println("Even number: " + i);
            }
        });

        // Task for odd numbers
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                System.out.println("Odd number: " + i);
            }
        });




        // Start both threads concurrently
        t1.start();
        t2.start();
    }
}