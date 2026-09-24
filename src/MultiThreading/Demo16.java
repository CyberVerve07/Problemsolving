package MultiThreading;

public class Demo16 {
    public static void main(String[] args) {
        Thread t1=new Thread();
        System.out.println("Main thread is start:");
        try {
            Thread.sleep(2000);//pause the current executing thread for the specific period of time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread is end ");
        t1.start();

        //So sleep method is used to sl
        //Thread.sleep() pauses the currently executing thread for a specified duration.
        // It does not release any monitor lock held by the thread.
//main thread in running stater after that it goes in -> timed waiting


    }
}
