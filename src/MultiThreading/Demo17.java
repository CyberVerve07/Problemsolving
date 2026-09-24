package MultiThreading;

public class Demo17 {
    public static void main(String[] args) {
        System.out.println("Main thread is started");

        Thread t1=new Thread(()->
                System.out.println("Thread 0 is Started:"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


         t1.start();
         try {
             t1.join();//let the t1 thread first execution
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
        System.out.println("Main thread is end ");


    }
}
//join() causes the current thread to wait until the target thread terminates.
// It is commonly used to establish a dependency between thread completion and subsequent execution.