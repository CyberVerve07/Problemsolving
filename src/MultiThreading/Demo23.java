package MultiThreading;

public class Demo23 extends Thread {
    int a;
     int b;
     int sum;

    public Demo23(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        // Perform the addition inside the thread execution path
        this.sum = a + b;
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) {
        Demo23 thread = new Demo23(15, 25);

        // Start the thread execution
        thread.start();

        try {
            // Wait for the thread to complete computation
            thread.join();
            System.out.println("Sum: " + thread.getSum());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}