package MultiThreading;

/**
 * Question 5: wait() and notify() / notifyAll() Demo
 * ----------------------------------------------------
 * Problem (Most Famous Interview Question):
 * Two threads use karke Even aur Odd numbers sequence me print karna (1 se 10 tak).
 *
 * Key Concepts of wait() & notify():
 * 1. Ye dono methods java.lang.Object class ke hain (Thread class ke nahi).
 * 2. Inhe sirf SYNCHRONIZED block ya method ke andar hi call kar sakte hain,
 *    warna 'IllegalMonitorStateException' aayegi.
 * 3. wait() call karne par thread current object ka LOCK RELEASE kar deta hai aur WAITING state me chala jata hai.
 * 4. notify() usi object par wait kar rahe kisi ek thread ko jagata hai (notifyAll() sabko jagata hai).
 */
class NumberPrinter {
    private int counter = 1;
    private final int MAX_LIMIT = 10;

    // Odd numbers print karne ke liye method
    public synchronized void printOdd() {
        while (counter <= MAX_LIMIT) {
            // Agar counter even hai, to odd thread ko wait karna hoga
            while (counter % 2 == 0) {
                try {
                    wait(); // Lock release karke waiting state me chala jayega
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (counter <= MAX_LIMIT) {
                System.out.println(Thread.currentThread().getName() + " printed (Odd): " + counter);
                counter++;
                notify(); // Even thread ko jagayega
            }
        }
    }

    // Even numbers print karne ke liye method
    public synchronized void printEven() {
        while (counter <= MAX_LIMIT) {
            // Agar counter odd hai, to even thread ko wait karna hoga
            while (counter % 2 != 0) {
                try {
                    wait(); // Lock release karke waiting state me chala jayega
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (counter <= MAX_LIMIT) {
                System.out.println(Thread.currentThread().getName() + " printed (Even): " + counter);
                counter++;
                notify(); // Odd thread ko jagayega
            }
        }
    }
}

public class P5_WaitNotifyDemo {

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        // Odd Thread
        Thread oddThread = new Thread(() -> printer.printOdd(), "Odd-Thread");

        // Even Thread
        Thread evenThread = new Thread(() -> printer.printEven(), "Even-Thread");

        oddThread.start();
        evenThread.start();
    }
}
