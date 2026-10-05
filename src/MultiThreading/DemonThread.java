package MultiThreading;

public class DemonThread {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {while (true) {
                System.out.println("Background work...");
            }
        });

        t.setDaemon(true);
        t.start();
    }
}
//In java, we have to type of thread first is user thread and 2nd is  Demon thread so
//Demon thread is used for is not perform the critical task that are mandatory to  execute and also it is used in he background tak
//the best example of the Demon thread is the Gc :: that is handle the background task
//It is not gurrented the demon thread is completed the work \
//====================================== Whaat is thread local -> eacha thread hjavve their own variale not a sharqable object
//Each thread gets its own isolated value associated with the ThreadLocal.
//============================================================================