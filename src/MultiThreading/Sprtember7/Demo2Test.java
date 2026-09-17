package MultiThreading.Sprtember7;

public class Demo2Test {
    static void main() {

        System.out.println("Main thread is started:");

         Thread thread
                 = Thread.startVirtualThread(new Demo2());


         thread.start();
         //Concurrency = dealing with multiple tasks
        //Parallelism = executing multiple tasks simultaneously
//Task means work
        //main method is the code which is executing by main thread



    }
}
