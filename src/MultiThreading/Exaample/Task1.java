package MultiThreading.Exaample;

public class Task1 extends Thread {
    public  void print(){
        System.out.println("Task 1"+currentThread().getName());
    }
    @Override
    public void run() {
        print();
    }
}
