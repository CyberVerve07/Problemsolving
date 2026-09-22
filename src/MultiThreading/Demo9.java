package MultiThreading;

public class Demo9 {
    public static void main(String[] args) {

        Task1 task1=new Task1();

        PrintThread1 t1=new PrintThread1(task1); //Dummy account
        t1.setName("Print thread");
        t1.start();


         PrintThread1 t2= new PrintThread1(task1);
         t2.setName("Print thread 2");
         t2.start();

    }
}

  class Task1{
    public synchronized void printNumbers(){   //Giving the control access to shared resource
        //So synchronized is the keyword in java used to prevent the ra//ce condition and data Invalidation also
        //synchronized means one thread can access the one shared resource at a time
        for(int i=0;i<=10;i++){
            System.out.println("Printing"+i+"["+Thread.currentThread().getName() );
        }
    }

  }


   class PrintThread1 extends Thread{

     Task1 task1;

       @Override
       public void run() {
           task1.printNumbers();

       }

       PrintThread1(Task1 task1){
         this.task1=task1;


     }

   }
   //In java each object and class have the exact one lock
