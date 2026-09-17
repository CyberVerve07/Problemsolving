package MultiThreading07;

 class MyThread extends Thread{

     @Override
     public void run() {
         System.out.println("Executing the run method");
         System.out.println("My thread : This code is executed by the ["+Thread.currentThread().getName());
     }
 }
public class Demo11 {
    public static void main(String[] args) {
        System.out.println("Start main");
        System.out.println("This code is executed by the ["+Thread.currentThread().getName());

        System.out.println("This is my hello world");

        MyThread T1=new MyThread();
        T1.start();
        MyThread T2=new MyThread();
        T2.start();
        MyThread T3=new MyThread();
        T3.start();
        MyThread T4=new MyThread();
        T4.start();
        System.out.println("Main is end ");
    }


}
