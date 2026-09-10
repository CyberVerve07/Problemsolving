package MultiThreading;

public class Counter {
    int count=0;
     public  void countincrement(){

         count++;
     }

}
class Test0{

    static void main() throws InterruptedException {

        Counter c1=new Counter();

        Thread t1=new Thread(()->c1.countincrement());
        Thread t2=new Thread(()->c1.countincrement());

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c1.count);

    }
}