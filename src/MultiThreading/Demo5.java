package MultiThreading;

public class Demo5 {
    static void main() throws InterruptedException {
        System.out.println("Main thread is start");

        Thread t1=new Thread(()-> System.out.println("Thread 1 is start:"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        t1.start();
        t1.join();
        System.out.println("Thread is end : ");



    }
}
//join