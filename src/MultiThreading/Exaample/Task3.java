package MultiThreading.Exaample;

public class Task3 extends  Thread{
    public  void  print(){
        System.out.println("Task3"+currentThread().getName());
    }

    @Override
    public void run() {
        print();
    }
}
