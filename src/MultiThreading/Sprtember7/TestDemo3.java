package MultiThreading.Sprtember7;

public class TestDemo3 {
    static void main(String[] args) {

     Thread t1=new Thread();

        System.out.println("The Crrent thread is "+Thread.currentThread().getName());
        System.out.println("ID of the thread "+Thread.currentThread().getId());

        Thread thread=new Thread(()->System.out.println("Name of my thread name is :"+
                Thread.currentThread().getName()));
//t1.start when ever we dont call it our thread is not created in the os


        thread.start();

    }
}
