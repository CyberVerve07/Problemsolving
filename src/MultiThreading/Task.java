package MultiThreading;

public class   implements  Runnable{

    @Override
    public void run() {
        System.out.println("Task.run");
    }



}
 class  Demo{
     public static void main(String[] args) {

         System.out.println("Task is started");

     }



 }
