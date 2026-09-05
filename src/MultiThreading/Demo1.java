package MultiThreading;

public class Demo1 {
    public static void main(String args[]){
        //In java thread is a lightweight subprocess.
         // In java every program have atleast one thread
        // Java supports multi threading means executing the multiple thread at the same time :


            // Print the same number of the current thread :

        System.out.println("Inside main thread:");
        System.out.println("Thread name :"+Thread.currentThread().getName());

    }

}

  class  MyThread extends Thread{
    public  void run(){
        System.out.println("Running the thread : by extending : ");
    }
  }