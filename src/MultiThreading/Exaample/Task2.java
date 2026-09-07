package MultiThreading.Exaample;

public class Task2 extends Thread{
    public  void  print(){
        System.out.println("Task 2:"+currentThread().getName());
    }


    @Override
    public void run() {
        print();
    }
}
