package MultiThreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Mythread extends Thread{

    int taskId;

    @Override
    public void run() {
        System.out.println("Executing Task " + taskId + " on thread: " + Thread.currentThread().getName());


    }
    public Mythread(int taskId){
        this.taskId=taskId;
    }
}

public class DEmo22 {
    //Thread Executor-frameWork in java

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        //executing the 10n task a
        for(int i=0;i<10;i++){
            Mythread task=new Mythread(i);
            executorService.execute(task);

        }
       // executorService.shutdown();

    }


}
//So the problem is that we dont know about the how manay threads we need to execute the task
// In java 5 the Executor framework is coming............