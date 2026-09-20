package MultiThreading;

/**
 * Question 3: yield() Method Demo
 * --------------------------------
 * Thread.yield() thread scheduler ko ek HINT deta hai ki current thread CPU release karne
 * aur dusre same/higher priority ke runnable threads ko execute hone ka mauka dene ke liye tayyar hai.
 *
 * Key Points:
 * 1. Ye static method hai: Thread.yield()
 * 2. Thread RUNNING state se RUNNABLE state me chala jata hai.
 * 3. Guarantee nahi hoti ki scheduler hint ko accept karega hi (OS and JVM dependent).
 * 4. Ye koi InterruptedException throw nahi karta (unlike sleep/wait).
 */
public class P3_YieldDemo {

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " running: iteration " + i);
                
                // Agar thread Thread-1 hai to yield call karke dusre thread ko chance dega
                if (Thread.currentThread().getName().equals("Thread-1")) {
                    System.out.println(Thread.currentThread().getName() + " yielding CPU control...");
                    Thread.yield();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        // Dono ko same priority dete hain
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
    }
}
